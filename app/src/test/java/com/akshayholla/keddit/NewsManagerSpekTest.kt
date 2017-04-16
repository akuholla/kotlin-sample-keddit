package com.akshayholla.keddit

import com.akshayholla.keddit.Extensions.mock
import com.akshayholla.keddit.api.NewsAPI
import com.akshayholla.keddit.api.RedditDataRespone
import com.akshayholla.keddit.api.RedditNewsResponse
import com.akshayholla.keddit.commons.models.RedditNews
import com.akshayholla.keddit.features.news.NewsManager
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.mock
import retrofit2.Call
import retrofit2.Response
import rx.observers.TestSubscriber

@RunWith(JUnitPlatform::class)
class NewsManagerSpekTest: Spek({
    describe("new Manager test") {
        var testSub = TestSubscriber<RedditNews>()
        var apiMock = mock<NewsAPI>()
        var callMock = mock<Call<RedditNewsResponse>>()

        beforeEachTest {
            testSub = TestSubscriber<RedditNews>()
            apiMock = mock<NewsAPI>()
            callMock = mock<Call<RedditNewsResponse>>()
            Mockito.`when`(apiMock.getNews(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(callMock)
        }

        it("should not return any error on receiving from subscription") {
            val redditNewsResponse = RedditNewsResponse(RedditDataRespone(listOf(), null, null))
            val response = Response.success(redditNewsResponse)

            Mockito.`when`(callMock.execute()).thenReturn(response)

            val newsManager = NewsManager(apiMock)
            newsManager.getNews("").subscribe(testSub)

            testSub.assertNoErrors()
            testSub.assertValueCount(1)
            testSub.assertCompleted()
        }
    }
})