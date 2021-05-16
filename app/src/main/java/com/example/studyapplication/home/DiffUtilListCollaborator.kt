package com.example.studyapplication.home

import androidx.recyclerview.widget.DiffUtil

open class DiffUtilListCollaborator {

    fun diffCallback(){
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListCollaborator>() {
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
}
