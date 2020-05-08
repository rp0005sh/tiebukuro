class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        // 全部の要素数
        int n = 10;

        // 配列用意して、代入していく
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = sc.nextInt();

        // 1つ目には3つ目の数値を3で割った商を代入する
        array[0] = array[2] / 3;

        // 1つ目に入っていた数値は3つ目に代入する。
        array[2] = array[0];

        // 2つ目には4つ目の数値、4つ目には6つ目の数値、6つ目には2つ目の数値を代入する。(数値の入れ替え)
        int tmp = array[1];
        array[1] = array[3];
        array[3] = array[5];
        array[5] = tmp;

        // 5つ目には、7つ目、8つ目、10つ目の数値の平均値を求めて代入する
        array[4] = (array[6] + array[7] + array[9]) / 3;

        // 8つ目の数値に9つ目の数値3で割った時の余りを代入
        array[7] = array[8] % 3;

        //10個の整数数値の順番を逆順に入れ替える
        for (int i = 0; i < n/2; i++) {
            tmp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = tmp;
        }

        // 配列の中身全部表示
        System.out.println(java.util.Arrays.toString(array));
    }
}

