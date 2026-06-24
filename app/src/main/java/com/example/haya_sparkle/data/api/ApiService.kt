package com.example.haya_sparkle.data.api

import com.example.haya_sparkle.data.model.NewsModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getNews(): Response<List<NewsModel>>
}