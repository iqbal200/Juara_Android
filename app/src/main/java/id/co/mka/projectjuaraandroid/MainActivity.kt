package id.co.mka.projectjuaraandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.co.mka.projectjuaraandroid.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil
import kotlin.math.cos

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            buttomClick.setOnClickListener { calculateTip() }
        }
    }

    private fun calculateTip() {
        val stringIntextField = binding.editText.text.toString()
        val cost = stringIntextField.toDouble()
        val selectedButton = binding.radioGrup.checkedRadioButtonId
        val tipPresentage = when (selectedButton){
            R.id.option_one -> 0.20
            R.id.option_two -> 0.18
            else -> 0.15
        }
        var tip = tipPresentage * cost

        var roundUp = binding.swicth.isChecked
        if (roundUp) {
            tip = ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }


}