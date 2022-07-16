package com.naziksoft.testfortapmobile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.naziksoft.testfortapmobile.databinding.MediaContentCardBinding
import com.naziksoft.testfortapmobile.entity.MediaContent
import com.naziksoft.testfortapmobile.viewmodel.SearchViewModel

class MediaContentAdapter(private val viewModel: SearchViewModel) : RecyclerView.Adapter<MediaContentAdapter.MediaContentViewHolder>() {

    private var media: List<MediaContent> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaContentViewHolder {
        val view = MediaContentCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MediaContentViewHolder(view)
    }

    override fun onBindViewHolder(holder: MediaContentViewHolder, position: Int) {
        holder.bind(media[position], viewModel)
    }

    override fun getItemCount() = media.size

    fun setData(media: List<MediaContent>) {
        this.media = media
        // todo diff utils
        notifyDataSetChanged()
    }

    class MediaContentViewHolder(private val viewHolder: MediaContentCardBinding) : RecyclerView.ViewHolder(viewHolder.root) {
        fun bind(song: MediaContent, viewModel: SearchViewModel) {
            with(viewHolder) {
                Glide.with(root).load(song.img).into(imageView)
                root.setOnClickListener { viewModel.onItemClicked(song) }
            }
        }
    }
}
