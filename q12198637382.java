import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

class Main {
    public static void main(String args[]) throws InterruptedException {
        // 評価エラーが起これば格納する
        String exceptionClass, message;
        // サービス起動
        ExecutorService exec = Executors.newSingleThreadExecutor();

        // 遅延評価要求
        Future<String> futue = exec.submit(() -> {
            // 遅延処理(とりあえず、1秒待ちしてみる)
            try{Thread.sleep(1000);}catch(InterruptedException e){}
            // 二分の一の確率でExceptionが発生
            if(Math.random() > 0.5) throw new Exception("残念");
            // Exceptionにならなければ"評価OK"を返す
            return  "評価OK";
        });

        // メインスレッドではなんか他の処理する
        //       :
        //       :

        try {
            // 評価結果を受ける
            String result = futue.get();
            System.out.println(result);

        } catch (ExecutionException e) { // もし評価中にExceptionが発生してたらこっちのルート
            // 評価スレッドで起こったExceptionを取得する
            Throwable err = e.getCause();
            exceptionClass = err.getClass().getName(); // クラス名取得
            message = err.getMessage();                // メッセージ取得
            System.err.println(message + " エラー発生：" + exceptionClass);
        }

        // サービスの終了
        exec.shutdown();
    }
}
