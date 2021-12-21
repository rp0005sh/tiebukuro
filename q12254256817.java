package com.sample.test.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /** ユーザの入力値保持変数 */
    private String user;

    /** 解答文字列を定義 */
    private static final String ANSWER = "ABCD";

    /** リセット処理 */
    private void reset() { user = ""; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reset();
    }

    /** 文字入りボタン押下イベント */
    public void onClickButton(View v) {
        user += ((TextView)v).getText().toString();
        if (user.length() == ANSWER.length()) {
            String msg = user.equals(ANSWER)? "正解" : "違います";
            reset();
            Toast.makeText(v.getContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    /** リセットボタン押下イベント */
    public void onClickReset(View v) {
        reset();
    }
}
