package com.khan.mvvmdesignpattern.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.khan.mvvmdesignpattern.R
import com.khan.mvvmdesignpattern.model.DataModelInterface
import com.khan.mvvmdesignpattern.model.DataModelInterfaceImpl
import com.khan.mvvmdesignpattern.viewModel.PostViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var dataModelInterface: DataModelInterface
    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialization()

        setLiveDataListener()

        postViewModel.getPosts(dataModelInterface)
    }

    private fun setLiveDataListener() {
        postViewModel.postsLiveData.observe(this, { posts ->
            Toast.makeText(this, "" + posts[99], Toast.LENGTH_LONG).show()
        })

        postViewModel.postsLFailureLiveData.observe(this, { errorMessage ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
        })
    }

    private fun initialization() {
        dataModelInterface = DataModelInterfaceImpl()
        postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)
    }
}