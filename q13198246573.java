public class Main {
    public static void main(String args[]) {
        // 条件文をオブジェクト化
        final java.util.function.IntPredicate check1, check2;
        // 数字の2か4で割り切れる
        check1 =  n -> n % 2 == 0 || n % 4 == 0;
        // 2か4が一つでも数値に含まれている
        check2 =  n -> String.valueOf(n).matches(".*[24].*");

        java.util.stream.IntStream
            .rangeClosed(1, 200)
            .mapToObj(n -> (check1).or(check2).test(n)
                ? String.valueOf(n).replaceAll(".", "X")
                : String.valueOf(n))
            .forEach(System.out::println);
    }
}
