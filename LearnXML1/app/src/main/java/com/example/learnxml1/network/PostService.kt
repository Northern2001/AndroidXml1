package com.example.learnxml1.network


import com.example.learnxml1.model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface PostService {
    @GET("/posts")
    fun getListPost() : Call<List<PostModel>>
}