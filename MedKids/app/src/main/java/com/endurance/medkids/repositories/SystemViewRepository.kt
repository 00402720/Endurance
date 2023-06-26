package com.endurance.medkids.repositories

import com.endurance.medkids.data.model.BodySystemModel

class SystemViewRepository(private val systems: MutableList<BodySystemModel>){

    fun getSystems() = systems


}