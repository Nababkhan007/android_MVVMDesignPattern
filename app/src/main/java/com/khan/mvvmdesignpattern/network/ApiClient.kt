package com.khan.mvvmdesignpattern.network

import com.khan.mvvmdesignpattern.model.data.Post
import retrofit2.Call
import retrofit2.http.*

interface ApiClient {
    @get:GET("posts")
    val getPosts: Call<List<Post>>
}