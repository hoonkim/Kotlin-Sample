package com.example.testapplication.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.R
import com.example.testapplication.data.entity.Data
import com.example.testapplication.databinding.DataItemBinding

class MainAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val datas = mutableListOf<Data>()

    fun submitList(newList:List<Data>) {
        val diffResult:DiffUtil.DiffResult = DiffUtil.calculateDiff(DiffCallBack(datas, newList))
        with(datas) {
            clear()
            addAll(newList)
        }
        Log.d("Hoon", "Submit list : " + newList)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding:DataItemBinding = DataBindingUtil.inflate(inflater, R.layout.data_item, parent, false)
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder:DataViewHolder = holder as DataViewHolder
        viewHolder.binding.data = datas[position]
        viewHolder.binding.executePendingBindings()
    }

    private class DataViewHolder(val binding: DataItemBinding) : RecyclerView.ViewHolder(binding.root)

      class DiffCallBack(val oldList:List<Data>, val newList:List<Data>) : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].key == newList[newItemPosition].key
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList == newList
        }

    }

}