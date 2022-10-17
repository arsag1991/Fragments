package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragments.databinding.Fragment1Binding
import com.example.fragments.databinding.Fragment2Binding


class BlankFragment2 : Fragment() {
    val dataModel : DataModel by activityViewModels()
    lateinit var binding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFragment2.observe(activity as LifecycleOwner) {
            binding.tvMessageFrag2.text = it
        }
        binding.bSendToFrag1.setOnClickListener {
            dataModel.messageForFragment1.value = "Hello from fragment 2"
        }
        binding.bSend2ToAct.setOnClickListener {
            dataModel.messageForActivity.value = "Hello activity From fragment 2"
        }

    }
    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}