package com.akshayholla.keddit

import com.akshayholla.keddit.api.*
import com.akshayholla.keddit.commons.models.RedditNews
import com.akshayholla.keddit.features.news.NewsManager
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import retrofit2.Call
import retrofit2.Response
import rx.observers.TestSubscriber
import java.util.*

class NewsManagerTest {

    var testSub = TestSubscriber<RedditNews>()
    var apiMock = mock<NewsAPI>()
    var callMock = mock<Call<RedditNewsResponse>>()

    @Before
    fun setup() {
        testSub = TestSubscriber<RedditNews>()
        apiMock = mock<NewsAPI>()
        callMock = mock<Call<RedditNewsResponse>>()
        `when`(apiMock.getNews(anyString(), anyString())).thenReturn(callMock)
    }

    @Test
    fun testSuccess_basic() {
        val redditNewsResponse = RedditNewsResponse(RedditDataRespone(listOf(), null, null))
        val response = Response.success(redditNewsResponse)

        `when`(callMock.execute()).thenReturn(response)

        val newsManager = NewsManager(apiMock)
        newsManager.getNews("").subscribe(testSub)

        testSub.assertNoErrors()
        testSub.assertValueCount(1)
        testSub.assertCompleted()
    }

    @Test
    fun testSuccess_checkOneNews() {
        val newsData = RedditNewsDataResponse(
                "author",
                "title",
                10,
                Date().time,
                "thumbnail",
                "url"
        )
        val newsResponse = RedditChildrenResponse(newsData)
        val redditNewsResponse = RedditNewsResponse(RedditDataRespone(listOf(newsResponse), null, null))
        val response = Response.success(redditNewsResponse)

        `when`(callMock.execute()).thenReturn(response)

        val newsManager = NewsManager(apiMock)
        newsManager.getNews("").subscribe(testSub)

        testSub.assertNoErrors()
        testSub.assertValueCount(1)
        testSub.assertCompleted()

        assert(testSub.onNextEvents[0].news[0].author == newsData.author)
        assert(testSub.onNextEvents[0].news[0].title == newsData.title)
    }

    @Test
    fun testError() {
        val responseError = Response.error<RedditNewsResponse>(500,
                ResponseBody.create(MediaType.parse("application/json"), ""))

        `when`(callMock.execute()).thenReturn(responseError)

        val newsManager = NewsManager(apiMock)
        newsManager.getNews("").subscribe(testSub)

        assert(testSub.onErrorEvents.size == 1)
    }

    inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)
}