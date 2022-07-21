package com.example.algo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.algo.databinding.FragmentDadosBinding

class DadosFragment : Fragment() {
    private lateinit var binding: FragmentDadosBinding
    private val dados = arrayOf<Int>(
        R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6
    )
    override fun onCreateView(
                inflater: LayoutInflater, container: ViewGroup?,
                savedInstanceState: Bundle?
            ): View? {
                binding= FragmentDadosBinding.inflate(layoutInflater)
                return binding.root
            }

            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                super.onViewCreated(view, savedInstanceState)
                binding.ivDado1.setOnClickListener { clickOnDado() }
                binding.ivDado2.setOnClickListener { clickOnDado() }
            }

            fun clickOnDado() {
                val d1 = (1..6).random()
                val d2 = (1..6).random()
                binding.ivDado1.setImageResource(dados[d1 - 1])
                binding.ivDado2.setImageResource(dados[d2 - 1])
                binding.tvContador.text = (d1 + d2).toString()
            }

        }
