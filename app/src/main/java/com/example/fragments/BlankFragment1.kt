package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragments.databinding.Fragment1Binding


class BlankFragment1 : Fragment() {
    val dataModel : DataModel by activityViewModels()
    lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFragment1.observe(activity as LifecycleOwner) {
            binding.tvMessageFrag1.text = it
        }
        binding.bSendToFrag2.setOnClickListener{
            dataModel.messageForFragment2.value = "Hello from fragment 1"
        }
        binding.bSend1ToAct.setOnClickListener {
            dataModel.messageForActivity.value = "Hello activity From fragment 1"
        }
    }
    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment1()
    }
}