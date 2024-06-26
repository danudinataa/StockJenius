package com.ramaa.pmobile_uas.data.remote

import com.ramaa.pmobile_uas.data.remote.response.CompanyResponse
import com.ramaa.pmobile_uas.data.remote.response.NewsResponse
import com.ramaa.pmobile_uas.data.remote.response.StockResponse
import com.ramaa.pmobile_uas.util.Constants
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface StockAPI {

    @GET("trending")
    suspend fun getStocks(
        @Query("page") page: Int,
        @Header("X-API-KEY") apiKey: String = Constants.API_KEY
    ): StockResponse

    @GET("{symbol}/profile")
    suspend fun searchCompany(
        @Path("symbol") symbol: String,
        @Header("X-API-KEY") apiKey: String = Constants.API_KEY
    ): CompanyResponse

    @GET("news")
    suspend fun getNews(
        @Query("page") page: Int,
        @Header("X-API-KEY") apiKey: String = Constants.API_KEY
    ): NewsResponse
}