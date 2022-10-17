package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val dataModel: DataModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startFragment(BlankFragment1.newInstance(), R.id.place_holder)
        startFragment(BlankFragment2.newInstance(), R.id.place_holder_2)

        dataModel.messageForActivity.observe(this) {
            binding.tvAct.text = it
        }

        /*supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_holder, BlankFragment1.newInstance())
            .commit()*/
    }
    private fun startFragment (f: Fragment, idHolder: Int){
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}