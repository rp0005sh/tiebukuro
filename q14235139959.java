import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.counting;

public class Main {
    public static void main(String[] args) {
        new java.util.Random().ints(400, 0, 20).boxed() // 乱数400個作る
            .collect(groupingBy(n -> n, counting()))    // 1～19のグループに分けてカウント
            .forEach((n, c) -> System.out.printf("%2dは%3d個です%n",n, c)); // 結果を表示
    }
}
