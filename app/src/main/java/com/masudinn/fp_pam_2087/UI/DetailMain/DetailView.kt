package com.masudinn.fp_pam_2087.UI.DetailMain

import com.masudinn.fp_pam_2087.Db.FavoriteMatch
import com.masudinn.fp_pam_2087.Model.Team.Teams

interface DetailView {
    interface View{
        fun displayTeamBadgeHome(team: Teams)
        fun setFavoriteState(favList:List<FavoriteMatch>)
        fun displayTeamBadgeAway(team: Teams)
    }

    interface Presenter{
        fun getTeamsBadgeAway(id:String)
        fun getTeamsBadgeHome(id:String)
        fun deleteMatch(id:String)
        fun insertMatch(eventId: String, homeId: String, awayId: String)
        fun checkMatch(id:String)

    }
}