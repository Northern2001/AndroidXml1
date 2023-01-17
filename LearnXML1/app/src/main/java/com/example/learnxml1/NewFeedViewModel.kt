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
    val mListPost: MutableLiveData<List<PostModel>> = MutableLiveData()

}