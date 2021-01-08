package com.masudinn.fp_pam_2087.UI.Favorite

import com.masudinn.fp_pam_2087.Model.MatchEvent.MatchEvent

interface FavoriteMatchView {
    interface View {
        fun hideLoading()
        fun showLoading()
        fun displayFootballMatch(matchList: List<MatchEvent>)
        fun hideSwipeRefresh()

    }

    interface Presenter {
        fun getFootballMatchData()

    }
}