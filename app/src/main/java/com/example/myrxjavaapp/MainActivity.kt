package com.example.myrxjavaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myrxjavaapp.databinding.ActivityMainBinding
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), FragmentListener {

    lateinit var binding: ActivityMainBinding
    private  val topFragment = TopFragment()
    private val bottomFragment = BottomFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }

    private fun setup() {
        initFragment()
    }

    private fun initFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(binding.topFrameLayout.id, topFragment)
        transaction.add(binding.bottomFrameLayout.id, bottomFragment)
        transaction.commit()
    }

    override fun onInputSent(input: CharSequence) {
        bottomFragment.setInputData(input.toString())
    }
}