package com.resourcefulparenting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.resourcefulparenting.databinding.ActivityMainBinding
import com.resourcefulparenting.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var homeFragment: HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_ResourcefulParenting)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}