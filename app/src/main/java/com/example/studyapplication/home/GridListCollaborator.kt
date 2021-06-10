package com.example.studyapplication.home

import androidx.annotation.DrawableRes
import com.example.studyapplication.R

data class GridListCollaborator(
    val name: String,
    val office: String,
    val city: String,
    @DrawableRes
    val photo: Int
)

val gridListCollaborators = listOf(
    GridListCollaborator("Tom Holland", "Desenvolvedor Android","Uberlândia/MG", R.drawable.iv_spider_man_x),
    GridListCollaborator("Tom Holland", "Desenvolvedor Android","Uberlândia/MG", R.drawable.iv_spider_man_x),
    GridListCollaborator("Tom Holland", "Desenvolvedor Android","Uberlândia/MG", R.drawable.iv_spider_man_x),
    GridListCollaborator("Tom Holland", "Desenvolvedor Android","Uberlândia/MG", R.drawable.iv_spider_man_x),
    GridListCollaborator("Tom Holland", "Desenvolvedor Android","Uberlândia/MG", R.drawable.iv_spider_man_x),
    GridListCollaborator("Tom Holland", "Desenvolvedor Android","Uberlândia/MG", R.drawable.iv_spider_man_x),
    GridListCollaborator("Tom Holland", "Desenvolvedor Android","Uberlândia/MG", R.drawable.iv_spider_man_x),
    GridListCollaborator("Tom Holland", "Desenvolvedor Android","Uberlândia/MG", R.drawable.iv_spider_man_x),
    GridListCollaborator("Tom Holland", "Desenvolvedor Android","Uberlândia/MG", R.drawable.iv_spider_man_x),
    GridListCollaborator("Tom Holland", "Desenvolvedor Android","Uberlândia/MG", R.drawable.iv_spider_man_x),
    GridListCollaborator("Tom Holland", "Desenvolvedor Android","Uberlândia/MG", R.drawable.iv_spider_man_x),
    GridListCollaborator("Tom Holland", "Desenvolvedor Android","Uberlândia/MG", R.drawable.iv_spider_man_x),
    GridListCollaborator("Tom Holland", "Desenvolvedor Android","Uberlândia/MG", R.drawable.iv_spider_man_x),
    GridListCollaborator("Tom Holland", "Desenvolvedor Android","Uberlândia/MG", R.drawable.iv_spider_man_x)
)