package com.example.roommemotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roommemotest.databinding.ActivityMainBinding
import com.example.roommemotest.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}