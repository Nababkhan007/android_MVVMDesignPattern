package com.khan.mvvmdesignpattern.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.khan.mvvmdesignpattern.common.RequestListener
import com.khan.mvvmdesignpattern.model.DataModelInterface
import com.khan.mvvmdesignpattern.model.data.Post

class PostViewModel : ViewModel() {
    val postsLiveData = MutableLiveData<List<Post>>()
    val postsLFailureLiveData = MutableLiveData<String>()
    val progressBarLiveData = MutableLiveData<Boolean>()

    fun getPosts(dataModelInterface: DataModelInterface) {
        dataModelInterface.getPosts(object : RequestListener<List<Post>> {
            override fun onRequestSuccess(data: List<Post>) {
                postsLiveData.postValue(data)
            }

            override fun onRequestFailed(errorMessage: String) {
                postsLFailureLiveData.postValue(errorMessage)
            }
        })
    }
}