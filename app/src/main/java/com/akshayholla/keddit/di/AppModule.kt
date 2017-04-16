package com.akshayholla.keddit.di

import android.content.Context
import com.akshayholla.keddit.KedditApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: KedditApp) {

    @Provides
    @Singleton
    fun provideContext() = app

    @Provides
    @Singleton
    fun provideApplication() = app as KedditApp
}
