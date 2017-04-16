package com.akshayholla.keddit

import android.app.Application
import com.akshayholla.keddit.di.DaggerNewsComponent
import com.akshayholla.keddit.di.NewsComponent

class KedditApp : Application() {

    companion object {
        lateinit var newsComponent: NewsComponent
    }

    override fun onCreate() {
        super.onCreate()
        newsComponent = DaggerNewsComponent.builder()
                .build()
    }
}
