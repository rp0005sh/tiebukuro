public class Main {
    public static void main(String[] args) {
        // 与式の左辺
        double sum = java.util.stream.IntStream.iterate(1, e -> e + 1) // 1, 2, 3, ...の連続する整数を無限に用意
            .filter(n -> (n % 3) != 0)  // 3の倍数をフィルターではじく 1, 2, 4, 5, 7, ...
            .limit(20)                  // 20項目まで抽出              1, 2, 4, 5, 7, ... , 29
            .map(n -> n * n * n * n)    // 4乗する                     1^4, 2^4, ... , 29^4
            .mapToDouble(n -> 1.0/n)    // 逆数をとる                  1/1^4, 1/2^4, ... , 1/29^4
            .sum();                     // 全部足す                    1/1^4 + 1/2^4 + ... + 1/29^4
        
        // 729かけて8で割って四乗根を取るとπになる
        double pi = Math.pow(sum * 729 / 8, 1.0/4);
        System.out.println(pi);
   }
}
