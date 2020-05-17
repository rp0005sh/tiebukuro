class Study01_4 {
    public static void main(String[] args) {
        final String[] week = {"日曜日", "月曜日", "火曜日", "水曜日","木曜日", "金曜日", "土曜日"};
        final int offset = java.util.Arrays.asList("sun", "mon", "tue", "wed","thu", "fri", "sat").indexOf(args[0]);

        while(true) {
            // 日の情報入力
            System.out.println("曜日を調べる日の情報を入力してください");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            int mm = sc.nextInt(), dd = sc.nextInt();

            // 日と月の両方が0の場合はプログラムを終了
            if (mm == 0 && dd == 0) {
                System.out.println("終了します");
                break;
            }

            // 日付計算して表示
            int count = java.time.LocalDate.of(2019, mm, dd).getDayOfYear();
            String w = week[(offset + count-1) % week.length];
            System.out.printf("%d月%d日は%sです。%n",mm, dd, w);
        }
    }
}
