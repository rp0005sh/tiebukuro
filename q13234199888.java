import java.util.stream.*;
import static java.util.Comparator.reverseOrder;

class Main {
    public static void main(String[] args) {

        // 入力値とランクの紐づけ
        var rank = IntStream.iterate(1, n -> n + 1).iterator();
        var map = Stream.of(args).distinct()
            .map(Integer::valueOf).sorted(reverseOrder())
            .collect(Collectors.toMap(String::valueOf, n -> rank.next()));
        
        System.out.println("入力順にランキングを表示");
        Stream.of(args).forEach(n -> System.out.println(n + " ： " + map.get(n) + "位"));
        System.out.println();

        System.out.println("ランキング順に入力値を表示");
        Stream.of(args).map(Integer::valueOf)
            .sorted(reverseOrder()).map(String::valueOf)
            .forEach(n -> System.out.println(map.get(n) + "位 ：" + n));
    }
}
