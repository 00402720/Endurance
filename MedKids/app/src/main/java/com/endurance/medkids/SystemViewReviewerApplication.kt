package com.endurance.medkids

import android.app.Application
import com.endurance.medkids.data.systems

import com.endurance.medkids.repositories.SystemViewRepository

class SystemViewReviewerApplication : Application() {
    val systemViewRepository: SystemViewRepository by lazy {
       SystemViewRepository(systems)
    }
}