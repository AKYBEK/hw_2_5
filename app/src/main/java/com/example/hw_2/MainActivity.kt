package com.example.hw_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hw_2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {

        with(binding) {


            calculateBtn.setOnClickListener {


                LoveService().api.getPercentage(


                    firtsName = firstName.text.toString(),
                    second = secondName.text.toString()
                ).enqueue(object : Callback<LoveModel> {


                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {


                        val intent = Intent(this@MainActivity, MainActivity2::class.java)
                        intent.putExtra("first", response.body()?.firstfName)
                        intent.putExtra("second", response.body()?.secondsName)
                        intent.putExtra("result", response.body()?.result)
                        intent.putExtra("percentage", response.body()?.percentage)
                        startActivity(intent)
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("MainActivity", "onFailure: ${t.message}")


                        // Show a Toast or Snackbar here to notify the user of the failure.
                    }
                })
            }
        }
    }
}