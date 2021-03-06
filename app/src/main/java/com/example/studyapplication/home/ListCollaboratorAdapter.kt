package com.example.studyapplication.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.studyapplication.databinding.ItemListCollaboratorBinding
import com.example.studyapplication.home.ListCollaboratorAdapter.ListCollaboratorViewHolder

class ListCollaboratorAdapter : ListAdapter<ListCollaborator, ListCollaboratorViewHolder>(DIFF_CALLBACK){

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListCollaborator>(){
            override fun areItemsTheSame(
                oldItem: ListCollaborator,
                newItem: ListCollaborator
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: ListCollaborator,
                newItem: ListCollaborator
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    class ListCollaboratorViewHolder(
        private val itemBinding: ItemListCollaboratorBinding
    ) : RecyclerView.ViewHolder(itemBinding.root){

        fun bind(listCollaborator: ListCollaborator){
            itemBinding.run {
                tvNameListCollaborator.text = listCollaborator.name
                tvOfficeListCollaborator.text = listCollaborator.office
                ivListCollaborator.setImageResource(listCollaborator.photo)
            }
        }

        companion object{
            fun create(parent: ViewGroup): ListCollaboratorViewHolder{
                val itemBinding = ItemListCollaboratorBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)

                return ListCollaboratorViewHolder(itemBinding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCollaboratorViewHolder {
        return ListCollaboratorViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ListCollaboratorViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
