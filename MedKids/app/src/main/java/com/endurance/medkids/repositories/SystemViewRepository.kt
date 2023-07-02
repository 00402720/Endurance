package com.endurance.medkids.repositories

import com.endurance.medkids.network.dto.BodySystemModel

class SystemViewRepository(private val systems: MutableList<BodySystemModel>){

    fun getSystems() = systems


}