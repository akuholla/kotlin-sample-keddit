package com.akshayholla.keddit.di

import com.akshayholla.keddit.api.NewsAPI
import com.akshayholla.keddit.api.NewsRestAPI
import com.akshayholla.keddit.api.RedditApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NewsModule {
    @Provides
    @Singleton
    fun provideNewsAPI(redditApi: RedditApi) = NewsRestAPI(redditApi) as NewsAPI

    @Provides
    @Singleton
    fun provideRedditApi(retrofit: Retrofit) = retrofit.create(RedditApi::class.java)
}
