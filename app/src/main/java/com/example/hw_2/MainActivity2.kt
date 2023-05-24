package com.example.hw_2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw_2.databinding.ActicityMain2Binding

class MainActivity2 : AppCompatActivity() {
    @Suppress("CAST_NEVER_SUCCEEDS")
    private lateinit var binding: ActicityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActicityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }

    private fun getData() {
        val firstName = intent.getStringExtra("first")
        val secondName = intent.getStringExtra("second")
        val result = intent.getStringExtra("result")
        val percentage = intent.getStringExtra("percentage")
        binding.tvFirstName.text=firstName
        binding.secondName.text=secondName
        binding.tvPercentage.text=percentage
        binding.tvResult.text=result

    }
}