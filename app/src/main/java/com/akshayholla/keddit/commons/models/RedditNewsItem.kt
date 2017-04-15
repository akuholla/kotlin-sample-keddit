package com.akshayholla.keddit.commons.models

data class RedditNewsItem(val author: String,
                          val title: String,
                          val numComment: Int,
                          val created: Long,
                          val thumbnail: String,
                          val url: String)