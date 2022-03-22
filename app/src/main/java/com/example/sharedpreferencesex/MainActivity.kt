package com.example.sharedpreferencesex

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferencesex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var name : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pref: SharedPreferences = getSharedPreferences("userName", MODE_PRIVATE)
        val editor = pref.edit()
        binding.dtnSave.setOnClickListener {
            editor.putString("이름1","홍길동")
            editor.apply()
        }

        binding.dtnDel.setOnClickListener {
            editor.remove("이름1")
            editor.apply()
        }

        name = pref.getString("이름1","값이 없습니다")

        binding.textView1.text = name




    }


}