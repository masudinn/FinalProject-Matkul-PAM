package com.masudinn.fp_pam_2087.Model.Team

import com.google.gson.annotations.SerializedName

data class TeamsResponse(@SerializedName("teams")
                         var teams: List<Teams>)