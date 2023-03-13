package com.example.converternumbersystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var buttonConvertere: Button
    lateinit var textNumber: EditText
    lateinit var myspinner: Spinner
    lateinit var myspinner2: Spinner
    lateinit var result: TextView
    var fromBase: Int = 2
    var toBase: Int = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        val base =
            mapOf<String, Int>("Binary" to 2, "Octal" to 8, "Hexadecimal" to 16, "Decimal" to 10)

        myspinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                fromBase = base[parent.getItemAtPosition(position).toString()]!!
                if (fromBase == 16) {
                    textNumber.inputType = InputType.TYPE_CLASS_TEXT
                } else {
                    textNumber.inputType = InputType.TYPE_CLASS_NUMBER
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        myspinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                toBase = base[parent.getItemAtPosition(position).toString()]!!

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }

    private fun initView() {
        buttonConvertere = findViewById(R.id.button)
        textNumber = findViewById(R.id.textView5)
        myspinner = findViewById(R.id.mySpinner)
        myspinner2 = findViewById(R.id.mySpinner2)
        result = findViewById(R.id.textView)
    }

    private fun updateToShow() {
        var x = textNumber.text.toString()
        var toShow = x.toIntOrNull(fromBase)
        if (!x.isEmpty() && toShow != null) {
            var toShow2 = toShow.toString(toBase)
            result.text = toShow2
        } else {
            val error = "Error Entry"
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }
    }

    public fun converterbutton(v: View) {
        updateToShow()
    }
}