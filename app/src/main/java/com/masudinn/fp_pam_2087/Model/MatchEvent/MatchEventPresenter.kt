package com.masudinn.fp_pam_2087.Model.MatchEvent

import com.masudinn.fp_pam_2087.Model.Team.TeamsResponse
import com.masudinn.fp_pam_2087.Server.RestApi
import io.reactivex.Flowable

class MatchEventPresenter (private val theSportDBRest: RestApi) : MatchEventView {


    override fun getUpcomingMatch(id: String): Flowable<MatchEventResponse> = theSportDBRest.getUpcomingMatch(id)

    override fun getFootballMatch(id: String): Flowable<MatchEventResponse> = theSportDBRest.getLastmatch(id)

    override fun getTeams(id: String): Flowable<TeamsResponse> = theSportDBRest.getTeam(id)

    fun getEventById(id: String): Flowable<MatchEventResponse> = theSportDBRest.getEventById(id)
}