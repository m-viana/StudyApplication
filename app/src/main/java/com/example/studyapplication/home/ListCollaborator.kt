package com.example.studyapplication.home

import androidx.annotation.DrawableRes
import com.example.studyapplication.R

data class ListCollaborator(
    val name: String,
    val office: String,
    @DrawableRes
    val photo: Int
)

val listCollaborators = listOf(
    ListCollaborator("Tom Holland", "Desenvolvedor Android", R.drawable.iv_spider_man_x),
    ListCollaborator("Tom Holland", "Desenvolvedor Android", R.drawable.iv_spider_man_x),
    ListCollaborator("Tom Holland", "Desenvolvedor Android", R.drawable.iv_spider_man_x),
    ListCollaborator("Tom Holland", "Desenvolvedor Android", R.drawable.iv_spider_man_x),
    ListCollaborator("Tom Holland", "Desenvolvedor Android", R.drawable.iv_spider_man_x),
    ListCollaborator("Tom Holland", "Desenvolvedor Android", R.drawable.iv_spider_man_x),
    ListCollaborator("Tom Holland", "Desenvolvedor Android", R.drawable.iv_spider_man_x),
    ListCollaborator("Tom Holland", "Desenvolvedor Android", R.drawable.iv_spider_man_x),
    ListCollaborator("Tom Holland", "Desenvolvedor Android", R.drawable.iv_spider_man_x),
    ListCollaborator("Tom Holland", "Desenvolvedor Android", R.drawable.iv_spider_man_x),
    ListCollaborator("Tom Holland", "Desenvolvedor Android", R.drawable.iv_spider_man_x),
    ListCollaborator("Tom Holland", "Desenvolvedor Android", R.drawable.iv_spider_man_x)
)
