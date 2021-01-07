package com.masudinn.fp_pam_2087.Model.MatchEvent

import com.masudinn.fp_pam_2087.Model.Team.TeamsResponse
import io.reactivex.Flowable

interface MatchEventView {
    fun getFootballMatch(id : String) : Flowable<MatchEventResponse>

    fun getTeams(id : String = "0") : Flowable<TeamsResponse>

    fun getUpcomingMatch(id : String) : Flowable<MatchEventResponse>

}