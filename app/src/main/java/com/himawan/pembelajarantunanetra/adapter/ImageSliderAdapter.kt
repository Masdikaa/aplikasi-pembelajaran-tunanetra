package com.himawan.pembelajarantunanetra.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.himawan.pembelajarantunanetra.databinding.ItemSlideBinding
import com.himawan.pembelajarantunanetra.model.ImageData

class ImageSliderAdapter(private val items: List<ImageData>) :
    RecyclerView.Adapter<ImageSliderAdapter.ImageViewHolder>() {
    inner class ImageViewHolder(itemView: ItemSlideBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        private val binding = itemView
        fun bind(data: ImageData) {
            with(binding) {
                Glide.with(itemView)
                    .load(data.imgOrgans)
                    .into(ivSlider)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemSlideBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
