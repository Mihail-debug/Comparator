package com.example.comparator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        price1.setHint(R.string.price)
        price2.setHint(R.string.price)
        count1.setHint(R.string.count)
        count2.setHint(R.string.count)

        var coast1 : Float = -1F
        var coast2 : Float = -1F
        var num1 : Float = -1F
        var num2 : Float = -1F
        var sum1 = -1F
        var sum2 = -1F

        Log.v("shit", "start")

        price1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
               coast1 = if (s.isNullOrEmpty()) {
                    -1F
                } else {
                    s.toString().toFloat()
                }
                sum1 = sum(coast1, num1, ans1)
                color(sum1, sum2, first, second)
                }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        price2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                coast2 = if (s.isNullOrEmpty()) {
                    -1F
                } else {
                    s.toString().toFloat()
                }
                sum2 = sum(coast2, num2, ans2)
                color(sum1, sum2, first, second)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        count1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                num1 = if (s.isNullOrEmpty()) {
                    -1F
                } else {
                    s.toString().toFloat()
                }
                sum1 = sum(coast1, num1, ans1)
                color(sum1, sum2, first, second)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        count2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                num2 = if (s.isNullOrEmpty()) {
                    -1F
                } else {
                    s.toString().toFloat()
                }
                sum2 = sum(coast2, num2, ans2)
                color(sum1, sum2, first, second)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        button.setOnClickListener {
            coast1 = -1F
            coast2 = -1F
            num1 = -1F
            num2 = -1F
            sum1 = -1F
            sum2 = -1F
            price1.setText("")
            price2.setText("")
            count1.setText("")
            count2.setText("")
            price1.setHint(R.string.price)
            price2.setHint(R.string.price)
            count1.setHint(R.string.count)
            count2.setHint(R.string.count)
            ans1.text = ""
            ans2.text = ""
            first.setBackgroundColor(Color.argb(100,204,204,204))
            second.setBackgroundColor(Color.argb(100,204,204,204))
        }

    }

    fun sum(coast: Float, num: Float, ans: TextView): Float {
        var sum :Float
        if ((coast >= 0) && (num > 0)) {
            sum = coast / num
            ans.text = "%.2f".format(sum)
            return sum
        } else {
            return -1F
        }
    }

    fun color(sum1: Float, sum2: Float, first: ConstraintLayout, second: ConstraintLayout) {
        if ((sum2 >= 0) && (sum1 >= 0)) {
            if (sum1 > sum2) {
                first.setBackgroundColor(Color.argb(100, 244, 67,54))
                second.setBackgroundColor(Color.argb(100, 76, 175,80))
            } else {
                if (sum1 == sum2) {
                    first.setBackgroundColor(Color.argb(100, 76, 175,80))
                    second.setBackgroundColor(Color.argb(100, 76, 175,80))
                } else {
                    first.setBackgroundColor(Color.argb(100, 76, 175,80))
                    second.setBackgroundColor(Color.argb(100, 244, 67,54))
                }
            }

        }
    }
}
