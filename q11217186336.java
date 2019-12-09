import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws java.io.IOException {
        // ファイルを読み込み
        List<String> list = Files.lines(Paths.get("data.csv"))
            .map(line -> line.split(","))
            .map(arr -> Arrays.stream(arr).sorted().collect(Collectors.joining(",")))
            .collect(Collectors.toList());

        // 読み込みデータを要素にバラす
        List<String> param = list.stream()
            .map(line -> line.split(","))
            .flatMap(Arrays::stream)
            .collect(Collectors.toList());

        String[] tmp;
        boolean check;
        do {
            // リスト内の値をシャッフルする   
            java.util.Collections.shuffle(param);

            // 二個ずつに分ける
            tmp = java.util.stream.IntStream.range(0, param.size()).boxed()
                .collect(Collectors.groupingBy(i -> i/2))
                .values().stream()
                .map(l -> l.stream().map(param::get).collect(Collectors.joining(",")))
                .toArray(String[]::new);

            // 読み込んだデータと同じものがないかチェック
            check = Arrays.stream(tmp)
                .map(line -> line.split(","))
                .map(arr -> Arrays.stream(arr).sorted().collect(Collectors.joining(",")))
                .anyMatch(list::contains);

        // 同じものがあればNG。シャッフルからやり直し
        } while (check);

        // 結果を表示する
        Arrays.stream(tmp).forEach(System.out::println);
    }
}
