class Main {

    public static void main(String[] args) throws InterruptedException {
        // Threadを30個プールするExecutor作って実行
        java.util.concurrent.ExecutorService exec = java.util.concurrent.Executors.newFixedThreadPool(30);
        for(int i = 0; i < 30; i++) exec.submit(r);

        // 30全部終わったら終了を表示。制限時間内(15秒)に終わらなければ、タイムアウトを表示
        exec.shutdown();
        if(exec.awaitTermination(15, java.util.concurrent.TimeUnit.SECONDS))System.out.println("Program end");
        else System.out.println("Time out");
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
