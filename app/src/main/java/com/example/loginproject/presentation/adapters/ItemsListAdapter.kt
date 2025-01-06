package com.example.loginproject.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.loginproject.R
import com.example.loginproject.data.ListItem
import com.example.loginproject.databinding.ListItemBinding

class ItemsListAdapter : RecyclerView.Adapter<ItemsListAdapter.ViewHolder>() {

    private var listItems: List<ListItem> = emptyList()
    private var clickListener: ClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, clickListener)
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    fun addItems(items: List<ListItem>) {
        listItems = items
        notifyDataSetChanged()
    }

    fun setClickListener(listener: ClickListener) {
        clickListener = listener
    }

    class ViewHolder(
        private val binding: ListItemBinding,
        private val clickListener: ClickListener?
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListItem) {
            binding.ivListIcon.setImageResource(item.iconSrc)
            binding.tvTitle.text = item.title
            binding.ivButton.setOnClickListener {
                clickListener?.onCLick(bindingAdapterPosition)
            }
        }
    }
}