package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton.OnCheckedChangeListener
import android.widget.Switch
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Switchにリスナー設定
        val sw = findViewById<Switch>(R.id.switch1)
        sw.setOnCheckedChangeListener(listener)

        // 10秒後自動でスイッチをOFFにする
        MainScope().launch {
            delay(10000)
            // Switchのリスナーを解除してから、スイッチOFF。その後、リスナー再設定
            sw.apply {
                setOnCheckedChangeListener(null)
                isChecked = false
                setOnCheckedChangeListener(listener)
            }
        }
    }
    /** スイッチの変化リスナーインスタンス */
    private val listener = OnCheckedChangeListener { _, flg ->
        Log.d("TAG", "flg=$flg")
    }
}
