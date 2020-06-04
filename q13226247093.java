class Main {
    public static void main(String[] args) {
        // 入力処理
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("年 --->");
        int y = sc.nextInt();
        System.out.print("月 --->");
        int m = sc.nextInt();
        System.out.print("1日の曜日は？ 日=0 月=1・・・金=5 土=6 --->");
        int offset = sc.nextInt();

        // 表示する月の日数を取得
        int days = java.time.Month.of(m).length(leap(y));

        // 表示する
        System.out.printf("-- %d 年 %d 月 のカレンダー --%n", y, m);
        System.out.printf("  日  月  火  水  木  金  土%n");
        for (int i = 0; i < days + offset; i++) {
            String format = (i < offset) ? "    " : ((i+1) % 7 == 0) ? "%4d%n" : "%4d";
            System.out.printf(format, i - offset + 1);
        }
    }

    // うるう年かチェックする
    static boolean leap(int year) {
        return java.time.Year.isLeap(year);
    }
}
