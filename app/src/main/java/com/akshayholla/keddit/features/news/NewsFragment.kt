package com.akshayholla.keddit.features.news

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.akshayholla.keddit.R
import com.akshayholla.keddit.commons.inflate

class NewsFragment : Fragment() {

    private var newslist: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.fragment_news)
        newslist = view?.findViewById(R.id.news_list) as RecyclerView?
        newslist?.setHasFixedSize(true)
        newslist?.layoutManager = LinearLayoutManager(context)

        return view
    }
}
