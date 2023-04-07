package com.sample.test.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ボタン押下でシェルを実行させる
        findViewById(R.id.button1).setOnClickListener(v -> {
            new Thread(() -> {
                try {
                    exec();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }).start();
        });
    }

    void exec() throws IOException {
        // 1. ProcessBuilderインスタンスを生成する
        //アプリの内部領域に「aaa.sh」シェルファイルを置いてて、それを「sh」コマンドで実行する場合
        ProcessBuilder p = new ProcessBuilder("sh"
                , Paths.get(getFilesDir().toString(),"aaa.sh").toString());

        // 2. プロセスを開始する
        Process process = p.start();

        // 3. 結果を受け取る
        try (BufferedReader r = new BufferedReader(
                new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = r.readLine()) != null) {
                Log.d("TAG", line);
            }
        }
    }
}
