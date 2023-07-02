package com.endurance.medkids.network.dto.createuser

import com.google.gson.annotations.SerializedName

data class CreateResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String,
    @SerializedName("updatedAt") val updateAt: String,
    @SerializedName("createAt") val createAt: String,
    @SerializedName("points") val points: Int,
    @SerializedName("profile_picture_id") val profile_picture_id: Int,
    @SerializedName("rank_id") val rank_id: Int

)