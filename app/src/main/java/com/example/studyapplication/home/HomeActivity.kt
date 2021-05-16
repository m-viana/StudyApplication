package com.example.studyapplication.home

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ConcatAdapter
import com.example.studyapplication.R
import com.example.studyapplication.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var listCollaboratorAdapter: ListCollaboratorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        initRecyclerView()
    }

    private fun initRecyclerView(){
        listCollaboratorAdapter = ListCollaboratorAdapter()
        binding.rvHome.adapter = ConcatAdapter(listCollaboratorAdapter)

        listCollaboratorAdapter.submitList(listCollaborators)

        val resId: Int = R.anim.layout_animation_fall_down
        val animation: LayoutAnimationController = AnimationUtils.loadLayoutAnimation(this, resId)
        binding.rvHome.layoutAnimation = animation
    }
}
