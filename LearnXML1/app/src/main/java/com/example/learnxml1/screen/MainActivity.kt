package com.example.learnxml1.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learnxml1.adapter.NewFeedAdapter
import com.example.learnxml1.databinding.ActivityMainBinding
import com.example.learnxml1.model.PostModel
import com.example.learnxml1.network.PostService
import com.example.learnxml1.network.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var rvNewFeedAdapter: NewFeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initView()
        createData()
    }

    private fun initView() {
        binding.apply {
            this.rvMain.layoutManager = LinearLayoutManager(this@MainActivity)
            rvNewFeedAdapter = NewFeedAdapter()
            this.rvMain.adapter = rvNewFeedAdapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun createData() {
        val retroInstance = Retrofit.getRetrofitInstance().create(PostService::class.java)
        val call = retroInstance.getListPost()

        call.enqueue(object : Callback<List<PostModel>>{
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                rvNewFeedAdapter.setData(response.body() ?: listOf())
                rvNewFeedAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.message,Toast.LENGTH_LONG).show()
                Log.e("onFailure", t.message.toString())
            }

        })



    }
}