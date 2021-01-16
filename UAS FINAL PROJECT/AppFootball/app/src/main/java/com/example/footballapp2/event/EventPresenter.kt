package com.example.footballapp2.event

import com.google.gson.Gson
import com.example.footballapp2.api.ApiRepository
import com.example.footballapp2.api.TheSportDBApi
import com.example.footballapp2.model.EventResponse
import com.larapin.kotlinsub2.model.EventSearchResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by Avin on 04/09/2018.
 */
class EventPresenter(private val view: EventView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson){
    fun getEventList(league: String?, event: String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getEvent(league, event)),
                    EventResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showEventList(data.events)
            }
        }
    }

//    fun getEventSearch(name: String?){
//        view.showLoading()
//        doAsync {
//            val data = gson.fromJson(apiRepository
//                    .doRequest(TheSportDBApi.getEventbySearch(name)),
//                    EventSearchResponse::class.java
//            )
//
//            uiThread {
//                view.hideLoading()
//                view.showEventList(data.event)
//            }
//        }
//    }
}
