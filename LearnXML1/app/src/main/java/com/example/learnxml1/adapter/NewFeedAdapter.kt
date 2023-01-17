package com.example.learnxml1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learnxml1.databinding.ItemNewFeedBinding
import com.example.learnxml1.model.PostModel

class NewFeedAdapter : RecyclerView.Adapter<NewFeedAdapter.ViewHolderPost>() {
    private var listPost = listOf<PostModel>()

    fun setData(data: List<PostModel>) {
        this.listPost = data
    }

    class ViewHolderPost(private val binding: ItemNewFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(title: PostModel) {
            binding.tvTitle.text = title.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPost {
        return ViewHolderPost(
            ItemNewFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listPost.size
    }

    override fun onBindViewHolder(holder: ViewHolderPost, position: Int) {
        holder.bind(listPost[position])
    }
}