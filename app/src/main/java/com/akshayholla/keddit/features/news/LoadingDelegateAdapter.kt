package com.akshayholla.keddit.features.news

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.akshayholla.keddit.R
import com.akshayholla.keddit.commons.adapter.ViewType
import com.akshayholla.keddit.commons.adapter.ViewTypeDelegateAdapter
import com.akshayholla.keddit.commons.extensions.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)
    )
}