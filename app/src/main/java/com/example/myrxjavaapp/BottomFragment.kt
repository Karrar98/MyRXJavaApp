package com.example.myrxjavaapp

import android.content.Context
import android.view.LayoutInflater
import com.example.myrxjavaapp.databinding.FragmentBottomBinding
import java.lang.RuntimeException

class BottomFragment : BaseFragment<FragmentBottomBinding>() {
    override val LOG_TAG: String = "BOTTOM_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentBottomBinding =
        FragmentBottomBinding::inflate

    override fun setup() {
    }

    fun setInputData(input: String) {
        binding?.txtShow?.text = input
    }

}