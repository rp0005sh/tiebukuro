class Main {

    public static void main(String[] args) throws InterruptedException {
        // 配列でスレッド30個生成
        Thread[] manager = new Thread[30];
        for(int i = 0; i < manager.length; i++) manager[i] = new Thread(r);
        
        // 全部処理開始
        for(Thread t : manager) t.start();

        // 処理完了待ち
        for(Thread t : manager)while(t.isAlive());
        System.out.println("Program end");
    }

    /**
     * スレッドでの実行オブジェクト
     */
    static final Runnable r = () -> {
        // 時刻書式指定
        final java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss");

        // スレッドID取得
        long id = Thread.currentThread().getId();

        // 開始時刻を取得
        String start = java.time.LocalTime.now().format(dtf);

        // 乱数で2から10秒待ち
        int rnd = java.util.concurrent.ThreadLocalRandom.current().nextInt(2, 11);
        try {Thread.sleep(rnd * 1000);}catch(InterruptedException e){}

        // 終了時刻を取得
        String end = java.time.LocalTime.now().format(dtf);

        // スレッドID，開始時刻，待ち秒数，終了時刻を表示 
        System.out.printf("%d start %s wait %d end %s%n", id, start, rnd, end);
    };
}
