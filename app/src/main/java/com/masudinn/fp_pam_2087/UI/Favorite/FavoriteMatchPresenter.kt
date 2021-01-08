package com.masudinn.fp_pam_2087.UI.Favorite

import com.masudinn.fp_pam_2087.Model.MatchEvent.MatchEvent
import com.masudinn.fp_pam_2087.Model.MatchEvent.MatchEventPresenter
import com.masudinn.fp_pam_2087.Repo.RepositoryPresenter
import com.masudinn.fp_pam_2087.Utils.AppScheduleProvider
import io.reactivex.disposables.CompositeDisposable

class FavoriteMatchPresenter (private val mView: FavoriteMatchView.View,
                              private val matchPresenter: MatchEventPresenter,
                              private val repositoryPresenter: RepositoryPresenter,
                              private val appSchedulerProvider: AppScheduleProvider
) : FavoriteMatchView.Presenter {

    override fun getFootballMatchData() {
        val compositeDisposable = CompositeDisposable()
        mView.showLoading()
        val favoriteList = repositoryPresenter.getMatchFromDb()

        val eventList: MutableList<MatchEvent> = mutableListOf()
        for (fav in favoriteList) {
            compositeDisposable.add(matchPresenter.getEventById(fav.idEvent)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe {
                    eventList.add(it.events[0])
                    mView.displayFootballMatch(eventList)
                    mView.hideLoading()
                    mView.hideSwipeRefresh()
                })
        }

        if (favoriteList.isEmpty()) {
            mView.hideLoading()
            mView.displayFootballMatch(eventList)
            mView.hideSwipeRefresh()
        }

    }
}