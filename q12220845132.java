/**
 * 配列を使用した方法
 */
class Main {
    public static void main(String args[]) {
        java.util.Random rnd = new java.util.Random();
        int[] array = new int[5];

        // 以下を5回繰り返す
        for (int mn = 0; mn < array.length; mn++) {
            // 0～100の乱数を生成して、配列に代入
            array[mn] = rnd.nextInt(100) + 1;
        }

        // 配列の中身を表示
        System.out.println(java.util.Arrays.toString(array));

        // 配列を昇順に並び替えると、配列の末尾が最大値になる
        java.util.Arrays.sort(array);
        System.out.println("max = " + array[array.length - 1]);
    }
}








/**
 * Math.maxを使用した方法
 */
class Main2 {
    public static void main(String args[]) {
        java.util.Random rnd = new java.util.Random();
        int max = 0;

        // 以下を5回繰り返す
        for (int mn = 0; mn < 5; mn++) {
            // 0～100の乱数を生成
            int mk = rnd.nextInt(100) + 1;

            // 表示
            System.out.println(mk);

            // maxとmkを比較して大きい方をmaxに代入
            max = Math.max(max, mk);
        }

        // 最後に最大値を出力
        System.out.println("max = " + max);
    }
}
