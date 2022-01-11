package com.sample.test.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class MainActivity : AppCompatActivity() {
    /** 時刻のフォーマット定義 */
    companion object {
        val FORMAT: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** ボタンが押された */
    fun onClickButton(v: View) {
        setTime()
    }

    /** カウントダウン時刻設定 */
    private fun setTime() {
        val tv = findViewById<TextView>(R.id.editTextTime)
        val btn = findViewById<TextView>(R.id.button)

        try {
            val time = LocalTime.parse(tv.text.toString(), FORMAT)
            btn.isEnabled = false

            object: CountDownTimer(time.toSecondOfDay() * 1000L, 1000) {
                override fun onTick(p0: Long) {
                    tv.text = LocalTime.ofSecondOfDay(p0/1000).format(FORMAT)
                }
                override fun onFinish() {
                    btn.isEnabled = true
                }
            }.start()
        }catch(e: DateTimeParseException) {
            Snackbar.make(tv, "フォーマットが不正です。HH:mm:ssで入力してください", 3000).show()
        }
    }
}
