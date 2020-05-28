class Main {
    public static void main(String[] args) {
        int[] ten = {45, 56, 96, 9, 78, 65, 38, 84, 63, 58, 100, 74, 41, 70, 62};
        String[] hist = {
            "  0 -   9 |",
            " 10 -  19 |",
            " 20 -  29 |",
            " 30 -  39 |",
            " 40 -  49 |",
            " 50 -  59 |",
            " 60 -  69 |",
            " 70 -  79 |",
            " 80 -  89 |",
            " 90 -  99 |",
            "100       |",
        };

        // tenの中身を読み込んで、ヒストグラムを更新する
        for (int n : ten) hist[n/10] += "*";

        // 結果を表示
        System.out.println("集計結果");
        System.out.println("---------------");
        for (String str : hist) System.out.println(str);
    }
}
