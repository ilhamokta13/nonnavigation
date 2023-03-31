package com.example.nonnavigation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nonnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listLetter = arrayListOf(
            DataList("A"),
            DataList("B"),
            DataList("C"),
            DataList("D"),
            DataList("E"),
            DataList("F"),
            DataList("G"),
            DataList("H"),
            DataList("I"),
            DataList("J"),
            DataList("K"),
        )

        val alphabetadapter = AlphabetAdapter(listLetter)
        val Manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewLetter.layoutManager = Manager
        binding.recyclerViewLetter.adapter = alphabetadapter
        alphabetadapter.onClick = {
            var bundle = Bundle()
            bundle.putString("key", it.key)
            val pindah = Intent(this, WordActivity::class.java)
            pindah.putExtras(bundle)
            startActivity(pindah)


        }
    }
}















