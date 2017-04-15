package com.akshayholla.keddit.features.news

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.akshayholla.keddit.R
import com.akshayholla.keddit.commons.adapter.ViewType
import com.akshayholla.keddit.commons.adapter.ViewTypeDelegateAdapter
import com.akshayholla.keddit.commons.extensions.getFriendlyTime
import com.akshayholla.keddit.commons.extensions.inflate
import com.akshayholla.keddit.commons.extensions.loadImg
import com.akshayholla.keddit.commons.models.RedditNewsItem
import kotlinx.android.synthetic.main.news_item.view.*

class NewsDelegateAdapter: ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = NewsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as NewsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class NewsViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item)
    ) {
       fun bind(item: RedditNewsItem) = with(itemView) {
           img_thumbnail.loadImg(item.thumbnail)
           description.text = item.title
           author.text = item.author
           comments.text = "${item.numComment} comments"
           time.text = item.created.getFriendlyTime()
       }
    }
}