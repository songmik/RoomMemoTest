package com.example.roommemotest

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roommemotest.databinding.ItemMemoBinding

class MemoAdapter(val list: MutableList<Memo>, private val itemClickListener: ItemClickListener ?= null
) : RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = ItemMemoBinding.inflate(inflater, parent, false)

        return MemoViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener { itemClickListener?.onClick(list[position]) }
    }

    class MemoViewHolder(private val binding: ItemMemoBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(memo: Memo) {
            binding.apply {
                titleTV.text = memo.title
                bodyTV.text = memo.body
                weatherChip.text = memo.weather
            }
        }
    }

    interface ItemClickListener {
        fun onClick(memo: Memo)
    }
}