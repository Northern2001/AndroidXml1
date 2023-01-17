package com.example.learnxml1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learnxml1.model.PostModel
import com.example.learnxml1.network.PostService
import com.example.learnxml1.network.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewFeedViewModel : ViewModel() {
    private val mListPost: MutableLiveData<List<PostModel>> = MutableLiveData()
    private val retroInstance = Retrofit.getRetrofitInstance().create(PostService::class.java)

    fun getListPostObserver(): MutableLiveData<List<PostModel>> {
        return mListPost
    }

    fun getListPost() {
        retroInstance.getListPost().enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                mListPost.postValue(response.body())
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                mListPost.postValue(null)
            }
        })
    }
}