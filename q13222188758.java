import java.util.stream.Stream;
import java.util.Map;
import java.time.Month;
import static java.util.stream.Collectors.*;
import static java.time.format.TextStyle.SHORT;
import static java.util.Locale.US;

class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // 月ごとの合計値を求める
        final int n = sc.nextInt();
        Map<Integer, Long> map = Stream
            .generate(() -> new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()}).limit(n)
            .collect(groupingBy(arr -> arr[1], summingLong(arr -> arr[0])));

        // １月から順番に合計値を表示
        map.entrySet().stream().sorted((e1, e2) -> e1.getKey() - e2.getKey())
            .forEach(e -> System.out.printf("%s:%d%n",
                Month.of(e.getKey()).getDisplayName(SHORT, US), e.getValue()));

        // 総計値を表示する
        System.out.printf("Total:%d%n",
            map.values().stream().mapToLong(Long::longValue).sum());
    }
}
