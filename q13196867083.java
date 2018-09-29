class Main {
    public static void main(String[] args) {
        int[] arr;
        java.util.Scanner sc = new java.util.Scanner(System.in); // (7),(8)の読み込みで使う

        // (1)
        arr = java.util.stream.IntStream.rangeClosed(1, 10)
            .sorted().toArray();
        System.out.println("(1):" + java.util.Arrays.toString(arr));
        
        // (2)
        arr = java.util.stream.IntStream.rangeClosed(2, 20)
            .filter(n -> n%2 == 0).sorted().toArray();
        System.out.println("(2):" + java.util.Arrays.toString(arr));

        // (3)
        arr = java.util.stream.IntStream.rangeClosed(90, 100)
            .map(n -> -n).sorted().map(n -> -n).toArray();
        System.out.println("(3):" + java.util.Arrays.toString(arr));

        // (4)
        arr = java.util.stream.IntStream.rangeClosed(71, 99)
            .filter(n-> n%2 == 1).map(n -> -n).sorted().map(n -> -n).toArray();
        System.out.println("(4):" + java.util.Arrays.toString(arr));

        // (5)
        arr = java.util.stream.IntStream.rangeClosed(1, 50)
            .filter(n-> n%3 == 0 || n%5 == 0).sorted().toArray();
        System.out.println("(5):" + java.util.Arrays.toString(arr));

        // (6)
        arr = java.util.stream.IntStream.rangeClosed(40, 100)
            .filter(n-> n%4 == 0 || n%7 == 0).map(n -> -n).sorted().map(n -> -n).toArray();
        System.out.println("(6):" + java.util.Arrays.toString(arr));
        
        // (7)
        System.out.print("(7):整数値を2個入力 > ");
        int abs = sc.nextInt() - sc.nextInt();
        System.out.println("(7):" + (abs > 0 ? abs : -abs));
        
        // (8)
        System.out.print("(8):整数値を10個入力 > ");
        java.util.IntSummaryStatistics summary = java.util.stream.IntStream.range(0, 10)
            .map(n -> sc.nextInt()).summaryStatistics();
        System.out.printf("(8):最大値：%d, 最小値：%d, 平均値：%f\n", summary.getMax(), summary.getMin(), summary.getAverage());
    }
}
