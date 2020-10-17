package com.khan.mvvmdesignpattern.common

interface RequestListener<T> {
    fun onRequestSuccess(data: T)
    fun onRequestFailed(errorMessage: String)
}