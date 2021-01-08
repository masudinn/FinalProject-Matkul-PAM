package com.masudinn.fp_pam_2087.UI.NextMatch

import com.masudinn.fp_pam_2087.Model.MatchEvent.MatchEvent

interface NextMatchView {
    interface View{
        fun hideLoading()
        fun showLoading()
        fun displayFootballMatch(matchList:List<MatchEvent>)

    }

    interface Presenter{
        fun getFootballUpcomingData()

    }
}