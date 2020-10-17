package com.khan.mvvmdesignpattern.model

import com.khan.mvvmdesignpattern.common.RequestListener
import com.khan.mvvmdesignpattern.model.data.Post
import com.khan.mvvmdesignpattern.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataModelInterfaceImpl : DataModelInterface {
    override fun getPosts(callback: RequestListener<List<Post>>) {
        RetrofitClient.instance.getPosts.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (!response.body().isNullOrEmpty())
                    callback.onRequestSuccess(response.body()!!)
                else
                    callback.onRequestFailed(response.message())
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                callback.onRequestFailed(t.message!!)
            }
        })
    }
}