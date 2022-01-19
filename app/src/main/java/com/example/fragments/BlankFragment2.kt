package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.fragments.databinding.Fragment2Binding


class BlankFragment2 : Fragment() {
    lateinit var binding: Fragment2Binding
    private val dataModel: DataModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataModel.messageForFrag2.observe(this, {
            binding.tvFrag2Message.text = it
        })
        binding.bSendToAct.setOnClickListener {
            dataModel.messageForActivity.value = "Hello activity from Fragment 2"
        }
        binding.bSendToFrag1.setOnClickListener {
            dataModel.messageForFrag1.value = "Hello from Fragment 2"
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}