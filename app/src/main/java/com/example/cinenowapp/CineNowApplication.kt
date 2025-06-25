package com.example.cinenowapp

import android.app.Application

class CineNowApplication : Application() {

    val repository by lazy {
        MovieNowLocalService.getRepository(this)
    }
}