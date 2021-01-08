package com.masudinn.fp_pam_2087.UI.LastMatch

import com.masudinn.fp_pam_2087.Model.MatchEvent.MatchEvent

interface LastMatchView {
    interface View{
        fun hideLoading()
        fun showLoading()
        fun displayFootballMatch(matchList:List<MatchEvent>)

    }

    interface Presenter{
        fun getFootballData()

    }
}