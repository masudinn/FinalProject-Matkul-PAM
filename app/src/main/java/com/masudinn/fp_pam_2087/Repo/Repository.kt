package com.masudinn.fp_pam_2087.Repo

import com.masudinn.fp_pam_2087.Db.FavoriteMatch

interface Repository {
    fun getMatchFromDb() : List<FavoriteMatch>

    fun insertData(eventId: String, homeId: String, awayId: String)

    fun deleteData(eventId: String)

    fun checkFavorite(eventId: String) : List<FavoriteMatch>
}