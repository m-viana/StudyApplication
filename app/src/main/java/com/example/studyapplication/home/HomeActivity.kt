package com.example.studyapplication.home

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.GridLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studyapplication.R
import com.example.studyapplication.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var listCollaboratorAdapter: ListCollaboratorAdapter
    private lateinit var gridListCollaboratorAdapter: GridListCollaboratorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        initRecyclerView()
    }

    private fun initRecyclerView(){

        /**Para usar com lista, usando ConcatAdapter**/
        /*listCollaboratorAdapter = ListCollaboratorAdapter()
        binding.rvListHome.adapter = ConcatAdapter(listCollaboratorAdapter)

        listCollaboratorAdapter.submitList(listCollaborators)

        val resId: Int = R.anim.layout_animation_fall_down
        val animation: LayoutAnimationController = AnimationUtils.loadLayoutAnimation(this, resId)
        binding.rvListHome.layoutAnimation = animation*/

        /**Para usar com Grid, usando ConcatAdapter**/
        gridListCollaboratorAdapter = GridListCollaboratorAdapter()
        binding.rvGridListHome.adapter = ConcatAdapter(gridListCollaboratorAdapter)
        gridListCollaboratorAdapter.submitList(gridListCollaborators)

        binding.rvGridListHome.layoutManager = GridLayoutManager(this, 3)

        val resId: Int = R.anim.grid_layout_animation_from_bottom
        val animation: LayoutAnimationController = AnimationUtils.loadLayoutAnimation(this, resId)
        binding.rvGridListHome.layoutAnimation = animation
    }
}
