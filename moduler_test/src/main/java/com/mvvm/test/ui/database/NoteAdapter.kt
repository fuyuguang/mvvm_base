package com.mvvm.test.ui.database

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.database.data.model.Note

import com.mvvm.test.databinding.ItemTestBinding

/**
 * Created by fuyuguang on 2022/10/21 11:54 AM.
 * E-Mail ：2355245065@qq.com
 * Wechat :fyg13522647431
 * Tel : 13522647431
 * 修改时间：
 * 类描述：
 * 备注：
    []()
    []()

 */
class NoteAdapter : RecyclerView.Adapter<NoteAdapter.VH>() {

    inner class VH(val binding: ItemTestBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.date == newItem.date
        }
    }

    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemTestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }


    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        val item = differ.currentList[position]
        holder.binding.apply {
            holder.itemView.setOnClickListener {
                onItemClickListener?.let { it(item) }
            }
            idInfo.text = "$item.date     ${item.id}"
        }
    }

    private var onItemClickListener: ((Note) -> Unit)? = null
    fun setOnItemClickListener(listener: (Note) -> Unit) {
        onItemClickListener = listener
    }
}