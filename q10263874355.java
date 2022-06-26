package com.sample.test.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScrollView scrollView = new ScrollView(this);
        setContentView(scrollView);
        TextView logText = new TextView(this);
        scrollView.addView(logText);

        // Logcat監視スレッド起動
        new Thread(new LogcatTask(new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 0) logText.append(msg.obj.toString() + "\n");
            }
        })).start();

        // 1秒周期で「hogehoge」ってログを吐くスレッド起動
        new Timer().schedule(new TimerTask() {
            @Override public void run() {
                Log.d("rp0005sh", "hogehoge");
            }
        },1000,1000);
    }


    /**
     * logcat を子プロセスで実行
     */
    static class LogcatTask implements Runnable {
        Handler mHandler;
        LogcatTask(Handler handler) {mHandler = handler;}

        @Override public void run() {
            Process process = null;
            try {
                //rp0005shってタグでフィルタリング
                String[] args = { "logcat", "-s", "rp0005sh:*"};
                process = Runtime.getRuntime().exec(args);
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));
                String data;
                while ((data = bufferedReader.readLine()) != null) {
                    // TextViewを更新するスレッドへログ内容を通知
                    mHandler.sendMessage(mHandler.obtainMessage(0, data));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 子プロセスを終わらせる
                if (process != null) process.destroy();
            }
        }
    }
}
