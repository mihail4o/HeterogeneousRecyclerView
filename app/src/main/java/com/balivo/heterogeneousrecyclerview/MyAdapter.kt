package com.balivo.heterogeneousrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class MyAdapter(private val mItems: List<Any>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // constant variables to indicate the view type.
// we will use this variables in getItemViewType method.
    companion object {
        private val TEXT_TYPE = 0
        private val IMAGE_TYPE = 1
    }

    // This method creates item layouts based on the value returned
// from the getItemViewType method
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder
        val inflater = LayoutInflater.from(parent.context)
        val text_layout = inflater.inflate(R.layout.text_row_layout, parent, false)
        val image_layout = inflater.inflate(R.layout.image_row_layout, parent, false)
        viewHolder = when (viewType) {
            TEXT_TYPE -> TextViewHolder(text_layout)
            IMAGE_TYPE -> ImageViewHolder(image_layout)
            else -> TextViewHolder(text_layout)
        }
        return viewHolder
    }

    // This method is called to bind the data to the layout
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            TEXT_TYPE -> {
                val textViewHolder = holder as TextViewHolder
                textViewHolder.bindData(position)
            }
            IMAGE_TYPE -> {
                val imageViewHolder = holder as ImageViewHolder
                imageViewHolder.bindData(position)
            }
            else -> {
                val textViewHolder = holder as TextViewHolder
                textViewHolder.bindData(position)
            }
        }
    }

    // Return Dataset size
    override fun getItemCount(): Int = mItems.size

    // Return the View type based on the item in the dataset
    override fun getItemViewType(position: Int): Int {
        if (mItems[position] is TextType) {
            return TEXT_TYPE // 0
        } else if (mItems[position] is ImageType) {
            return IMAGE_TYPE // 1
        }
        return -1
    }

    // ViewHolder for TextType layout
    inner class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mTextView: TextView = itemView.findViewById(R.id.textView)
        fun bindData(position: Int) {
            val textType = mItems[position] as TextType
            mTextView.text = textType.textVal
        }
    }

    // ViewHolder for ImageType layout
    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mImageView: ImageView = itemView.findViewById(R.id.imageView)
        fun bindData(position: Int) {
            val imageType = mItems[position] as ImageType
            mImageView.setImageResource(imageType.imgVal)
        }
    }
}