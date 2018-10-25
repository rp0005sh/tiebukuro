class Main {
    public static void main(String[] args){
        // 数値入力
        System.out.print("数値入力 -> ");
        int N = new java.util.Scanner(System.in).nextInt();

        // 約数の配列を作る
        int[] arr = java.util.stream.IntStream
            .rangeClosed(1, N)       // 1からNまでの数字を用意
            .filter(a -> N % a == 0) // 要素aが約数かどうかをチェック
            .toArray();

        // 約数配列の全要素出力
        System.out.println("約数：" + java.util.Arrays.toString(arr)); 

        // 約数配列の要素数が2個なら「素数」
        if(arr.length == 2) System.out.println("素数が入力されました。"); 
    }
}
