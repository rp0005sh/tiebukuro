package com.sample.test.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;

import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtonColor();
    }
  
    /** ボタン押下イベント */
    public void onClick(View v) {
        initButtonColor();
        v.setBackgroundTintList(ColorStateList.valueOf(
                ContextCompat.getColor(this, android.R.color.holo_blue_bright)));
    }
  
    /** 全ボタンの色を初期化する*/
    private void initButtonColor() {
        IntStream.of(R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10, R.id.btn11, R.id.btn12,R.id.btn13)
                .mapToObj(this::findViewById).forEach(v1 ->
                ((View) v1).setBackgroundTintList(ColorStateList.valueOf(
                        ContextCompat.getColor(this, android.R.color.background_dark))));
    }
}
