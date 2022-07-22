package com.example.algo

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import com.example.algo.databinding.FragmentImcBinding
import com.google.android.material.snackbar.Snackbar

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
        binding = FragmentImcBinding.inflate(layoutInflater)
        return binding.root
        calcObesidad()
        binding.skbHeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.tvHeightValue.text = progress.toString().plus("/200")
                height = progress
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) { calcIMC() }
        })

        binding.skbWeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.tvWeightValue.text = progress.toString().plus("/150")
                weight = progress
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) { calcIMC() }
        })

        b.imageView.setOnClickListener { showTable() }
    }

    fun calcIMC () {
        doubleHeight = height.times(height)/10000.0
        IMC = Math.round((weight/doubleHeight)
            .times(100))
            .div(100.0)
        binding.tvIMC.text = IMC.toString()
        calcObesidad()
    }

    fun calcObesidad () {
        var colorSnackbar = when (IMC){
            in 0.0..15.99 -> ContextCompat.getColor(this, R.color.delgadez_severa)
            in 16.0..16.99 -> ContextCompat.getColor(this, R.color.delgadez_moderada)
            in 17.0..18.49 -> ContextCompat.getColor(this, R.color.delgadez_leve)
            in 18.5..24.99 -> ContextCompat.getColor(this, R.color.normal)
            in 25.0..29.99 -> ContextCompat.getColor(this, R.color.preobesidad)
            in 30.0..34.99 -> ContextCompat.getColor(this, R.color.obesidad_leve)
            in 35.0..39.99 -> ContextCompat.getColor(this, R.color.obesidad_media)
            else -> ContextCompat.getColor(this, R.color.obesidad_morbida)
        }
        val obesidad = when (IMC){
            in 0.0..15.99 -> "DELGADEZ SEVERA"
            in 16.0..16.99 -> "DELGADEZ MODERADA"
            in 17.0..18.49 -> "DELGADEZ LEVE"
            in 18.5..24.99 -> "NORMAL"
            in 25.0..29.99 -> "PREOBESIDAD"
            in 30.0..34.99 -> "OBESIDAD LEVE"
            in 35.0..39.99 -> "OBESIDAD MEDIA"
            else -> "OBESIDAD MÓRBIDA"
        }
        val sb = Snackbar.make(binding.root, obesidad, Snackbar.LENGTH_LONG)
        sb.setTextColor(Color.WHITE)
        sb.setBackgroundTint(colorSnackbar)
        sb.setActionTextColor(Color.DKGRAY)
        sb.setAction("Ver Tabla"){
            showTable()
        }
        sb.show()
    }
    fun showTable(){
        val dialog = TableFragment()
        dialog.show(supportFragmentManager, "TablaPeso")
    }
}