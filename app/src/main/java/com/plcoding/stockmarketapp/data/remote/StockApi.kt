package com.plcoding.stockmarketapp.data.remote

import com.plcoding.stockmarketapp.data.remote.dto.CompanyInfoDto
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {

    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apiKey: String = API_KEY
    ): ResponseBody

    //https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY_EXTENDED
    // &symbol=IBM&interval=15min&slice=year1month1&apikey=demo

    //https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo

    //https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo&datatype=csv
    //
    @GET("query?function=TIME_SERIES_INTRADAY&interval=60min")
    suspend fun getIntradayInfo(
        @Query("symbol") symbol: String,
        @Query("apikey") apiKey: String = API_KEY
    ): ResponseBody

    @GET("query?function=OVERVIEW")
    suspend fun getCompanyInfo(
        @Query("symbol") symbol: String,
        @Query("apikey") apiKey: String = API_KEY
    ): CompanyInfoDto

    companion object {
        const val API_KEY = "QSZ25PE54YC0TEO7"
        const val BASE_URL = "https://alphavantage.co"
    }
}