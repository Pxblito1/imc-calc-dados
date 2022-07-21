package com.example.algo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.algo.databinding.FragmentImcBinding

class ImcFragment : Fragment() {
    private lateinit var binding: FragmentImcBinding
    var height = 150
    var weight = 75
    var doubleHeight = 2.25
    var IMC = 33.33
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding=FragmentImcBinding.inflate(layoutInflater)
        return binding.root
    }
}