package com.masudinn.fp_pam_2087.UI.NextMatch

import com.masudinn.fp_pam_2087.Model.MatchEvent.MatchEventPresenter
import com.masudinn.fp_pam_2087.Utils.ScheduleProviderView
import io.reactivex.disposables.CompositeDisposable

class NextMatchPresenter (private val mView: NextMatchView.View, private val matchEventPresenter: MatchEventPresenter, private val schedulers: ScheduleProviderView) : NextMatchView.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getFootballUpcomingData() {
        mView.showLoading()
        compositeDisposable.add(matchEventPresenter.getUpcomingMatch("4332")
            .observeOn(schedulers.ui())
            .subscribeOn(schedulers.io())
            .subscribe {
                mView.displayFootballMatch(it.events)
                mView.hideLoading()

            })
    }
}