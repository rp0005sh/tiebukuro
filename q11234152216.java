import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        for (int x = 1; x <= 9; x++) {
            for (int y = 1; y <= 9; y++) {
                // 回文を作る
                int target = 101 * x + 10 * y;

                // 素数かチェックする
                if (IntStream.rangeClosed(2, (int)Math.sqrt(target)).noneMatch(n -> target % n == 0)) {
                    // 素数なら表示
                    System.out.println(target);
                }
            }
        }
    }
}
