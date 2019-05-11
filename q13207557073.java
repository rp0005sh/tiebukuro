class Main {
    public static void main(String[] args) {
        // サンプルデータとして
        // -1000～10000の範囲の整数乱数を40個作る
        java.util.List<Integer> list = new java.util.Random().ints(40, -1000, 1000)
        .boxed().collect(java.util.stream.Collectors.toList());


        // List内で一番表示文字数の多い文字数を取得
        int len = list.stream().mapToInt(i -> i.toString().length()).max().orElse(0);

        // 最大文字数に合わせてフォーマットを作成
        String format = "%" + len + "d";

        // 表示処理
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String end = (((i+1) % 10) == 0) ? "%n" : ", "; // 改行判定
            System.out.printf(format + end, list.get(i));
        }
    }
}
