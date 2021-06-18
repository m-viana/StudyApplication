package com.example.studyapplication.register

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.size
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.studyapplication.R
import com.example.studyapplication.databinding.ActivityRegisterBinding
import com.example.studyapplication.register.fragments.AcessPasswordFragment
import com.example.studyapplication.register.fragments.AddressFragment
import com.example.studyapplication.register.fragments.ContactFragment
import com.example.studyapplication.register.fragments.PersonalIdentificationFragment
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class RegisterActivity : AppCompatActivity() {

    private lateinit var viewpager: ViewPager2
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewpager = binding.viewPagerRegister

        val fragments: ArrayList<Fragment> = arrayListOf(
            PersonalIdentificationFragment(),
            ContactFragment(),
            AddressFragment(),
            AcessPasswordFragment()
        )

        val adapter = ViewPagerAdapter(fragments, this)
        viewpager.adapter = adapter

        val wormDotsIndicator = findViewById<WormDotsIndicator>(R.id.indicator_register)
        wormDotsIndicator.setViewPager2(viewpager)

        binding.btnNext.setOnClickListener {
            if (viewpager.currentItem == fragments.size -1){
                Toast.makeText(this, "Ir para home", Toast.LENGTH_SHORT).show()
            } else {
                viewpager.setCurrentItem(viewpager.currentItem + 1, true)
            }
        }

        binding.btnBack.setOnClickListener{
            if(viewpager.currentItem == 0) onBackPressed()
            else viewpager.setCurrentItem(viewpager.currentItem - 1, true)
        }
    }

    override fun onBackPressed() {
        if(viewpager.currentItem == 0) super.onBackPressed()
        else viewpager.currentItem = viewpager.currentItem -1
    }
}