package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.fragments.databinding.Fragment1Binding


class BlankFragment : Fragment() {
    lateinit var binding: Fragment1Binding
    private val dataModel: DataModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataModel.messageForFrag1.observe(this, {
            binding.tvFrag1Message.text = it
        })
        binding.bSendToFrag2.setOnClickListener {
            dataModel.messageForFrag2.value = "Hello from Fragment 1"
        }
        binding.bSendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Hello activity from Fragment 1"
        }
        }


    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}