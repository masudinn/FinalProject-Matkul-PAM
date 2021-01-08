package com.masudinn.fp_pam_2087.UI.LastMatch

import com.masudinn.fp_pam_2087.Model.MatchEvent.MatchEventPresenter
import com.masudinn.fp_pam_2087.Utils.ScheduleProviderView
import io.reactivex.disposables.CompositeDisposable

class LastMatchPresenter(
    private val mView: LastMatchView.View, private val matchEventPresenter: MatchEventPresenter,
    private val appSchedulerProvider: ScheduleProviderView
) : LastMatchView.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getFootballData() {
        mView.showLoading()
        compositeDisposable.add(matchEventPresenter.getFootballMatch("4332")
            .observeOn(appSchedulerProvider.ui())
            .subscribeOn(appSchedulerProvider.io())
            .subscribe {
                mView.displayFootballMatch(it.events)
                mView.hideLoading()

            })
    }
}