import java.util.stream.Collectors;

class Main {
    public static void main(String[] t) {
        // 乱数100個生成（大きさの指定がないので、とりあえず0～100までの整数乱数とする)
        new java.util.Random().ints(100, 0, 100)
        // 昇順ソート
        .sorted()
        // 階級幅10でヒストグラムに変形
        .boxed().collect(Collectors.groupingBy(n -> n/10))
        // ヒストグラムを昇順ソート
        .entrySet().stream().sorted((e1, e2) -> e1.getKey() - e2.getKey())
        // 棒グラフで出力
        .forEach(e -> {
            String label = e.getValue().stream().map(n -> "■").collect(Collectors.joining());
            int start = e.getKey() * 10;
            int end   = start + 9;
            System.out.printf("%2d-%2d|%s%n", start, end, label);
        });
    }
}
