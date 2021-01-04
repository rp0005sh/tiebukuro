import android.os.Handler;
import android.util.Log;

class test {

    public void notify (String message, Handler h) {
        Comm t = new Comm(message, h);
        t.start();
    }

    static class Comm extends Thread {
        // ★メンバ変数にハンドラーを持たせておく
        private final Handler handler;

        private String message;

        Comm(String message, Handler h) {
            this.message = message;
            this.handler = h;
        }

        @Override
        public void run () {
            // Androidではログ出力にSystem.out.printlnは使いません。Logクラスを使用します。
            //System.out.println("プログラム実行");

            // このスレッドでやりたい処理
            // :
            // :

            // 最後にHandler#post
            handler.post(new Runnable() {
               // この↓run()の処理はMainThreadで実行される
                @Override public void run() {
                    Log.d("TAG", "プログラム実行" + Thread.currentThread());
                }
            });
        }
    }
}
