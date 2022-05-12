package com.example.retrofitsnova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitsnova.databinding.ActivityMainBinding
import com.example.retrofitsnova.screense.userlist.UserFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, UserFragment())
            .commit()

    }
}