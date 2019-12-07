import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws java.io.IOException {
        // ファイルを読み込んで、変数に保存
        List<String> list = Files.lines(Paths.get("data.csv"))
            .map(l -> l.split(","))
            .map(arr -> {Arrays.sort(arr); return arr[0] + "," + arr[1];})
            .collect(java.util.stream.Collectors.toList());
        
        // 要素にばらす
        List<String> param = list.stream()
        .map(line -> line.split(","))
        .flatMap(Arrays::stream)
        .collect(java.util.stream.Collectors.toList());
        
        while (true) {
            // リスト内の値をシャッフルする   
            java.util.Collections.shuffle(param);

            // 二個ずつに分ける
            String[] tmp =
            java.util.stream.IntStream(0, param.size())
            .collect(Collectors.groupingBy(i -> i/2, i -> param.get(i)))
            .values().stream().map(l -> l.toArray(new String[0]))
            .toArray(String[]::new);

            // check
            Arrays.stream(tmp)
            .map(arr -> {Arrays.sort(arr); return arr[0] + "," + arr[1];})
            .filter(list::contains)
            
            
        }
        
    }
}
