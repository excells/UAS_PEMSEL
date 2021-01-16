package com.example.footballapp2.api

import com.example.footballapp2.BuildConfig

/**
 * Created by Avin on 04/09/2018.
 */

object TheSportDBApi {
    fun getEvent(league: String?, event: String?): String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/"+event+".php?id="+league
    }

    fun getEventDetail(eventId: String?): String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupevent.php?id="+eventId
    }

//    fun getEventbySearch(event: String?): String{
//        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/searchevents.php?e=" +event
//    }
}