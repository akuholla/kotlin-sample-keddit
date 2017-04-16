package com.akshayholla.keddit.di

import com.akshayholla.keddit.features.news.NewsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NetworkModule::class,
        NewsModule::class
))
interface NewsComponent {
    fun inject(newsFragment: NewsFragment)
}