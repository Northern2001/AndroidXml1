package com.example.learnxml1.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learnxml1.NewFeedViewModel
import com.example.learnxml1.adapter.NewFeedAdapter
import com.example.learnxml1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var rvNewFeedAdapter: NewFeedAdapter
    private val newFeedViewModel = NewFeedViewModel()

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
        newFeedViewModel.getListPost()
        newFeedViewModel.getListPostObserver().observe(this) {
            if (it != null) {
                rvNewFeedAdapter.setData(it)
                rvNewFeedAdapter.notifyDataSetChanged()
                Log.e("createData", "${it[0].id}" )
            }
        }
    }
}