package com.example.studyapplication.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.studyapplication.databinding.ItemGridCollaboratorBinding
import com.example.studyapplication.home.GridListCollaboratorAdapter.*

class GridListCollaboratorAdapter : ListAdapter<GridListCollaborator, GridListCollaboratorViewHolder>(DIFF_CALLBACK){

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GridListCollaborator>(){
            override fun areItemsTheSame(
                oldItem: GridListCollaborator,
                newItem: GridListCollaborator
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: GridListCollaborator,
                newItem: GridListCollaborator
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    class GridListCollaboratorViewHolder(
        private val itemBinding: ItemGridCollaboratorBinding
    ) : RecyclerView.ViewHolder(itemBinding.root){

        fun bind(gridListCollaborator: GridListCollaborator){
            itemBinding.run {
                tvGridName.text = gridListCollaborator.name
                tvGridOffice.text = gridListCollaborator.office
                tvGridCity.text = gridListCollaborator.city
                ivGridPhoto.setImageResource(gridListCollaborator.photo)
            }
        }

        companion object{
            fun create(parent: ViewGroup): GridListCollaboratorViewHolder{
                val itemBinding = ItemGridCollaboratorBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)

                return GridListCollaboratorViewHolder(itemBinding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridListCollaboratorViewHolder {
        return GridListCollaboratorViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: GridListCollaboratorViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
