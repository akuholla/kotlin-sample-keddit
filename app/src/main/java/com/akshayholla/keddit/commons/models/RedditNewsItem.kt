package com.akshayholla.keddit.commons.models

import com.akshayholla.keddit.commons.adapter.AdapterConstants
import com.akshayholla.keddit.commons.adapter.ViewType

data class RedditNewsItem(val author: String,
                          val title: String,
                          val numComment: Int,
                          val created: Long,
                          val thumbnail: String,
                          val url: String) : ViewType {
                                                override fun getViewType() = AdapterConstants.NEWS
}