package com.khan.mvvmdesignpattern.model

import com.khan.mvvmdesignpattern.common.RequestListener
import com.khan.mvvmdesignpattern.model.data.Post

interface DataModelInterface {
    fun getPosts(callback: RequestListener<List<Post>>)
}