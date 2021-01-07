package com.masudinn.fp_pam_2087.Server

import com.masudinn.fp_pam_2087.Model.MatchEvent.MatchEventResponse
import com.masudinn.fp_pam_2087.Model.Team.TeamsResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {
    @GET("eventspastleague.php")
    fun getLastmatch(@Query("id") id:String) : Flowable<MatchEventResponse>

    @GET("eventsnextleague.php")
    fun getUpcomingMatch(@Query("id") id:String) : Flowable<MatchEventResponse>

    @GET("lookupteam.php")
    fun getTeam(@Query("id") id:String) : Flowable<TeamsResponse>


    @GET("lookupevent.php")
    fun getEventById(@Query("id") id:String) : Flowable<MatchEventResponse>
}
