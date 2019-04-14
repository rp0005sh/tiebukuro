public class Main {

    public static void main(String[] args) {
        int N = 10000;

        // 手順1.エラトステネスのふるいを用い、nまでの素因数分解を行い、得られた結果を、配列変数resultに代入
        int[] result = Eratosthenes(N);

        // 1~N(=10000)まで繰り返す
        for (int num = 1; num <= N; num++) {
            int n = num;
            int[] pf = new int[N];

            // 手順2, 3 変数i,jを用意し、0を代入する。
            int i = 0, j = 0;

            do {
                // 手順4 result[i]で、nを割った余りが0であれば、その値をpf[j]に代入し、jに1を足す
                if (n % result[i] == 0) {
                    pf[j++] = result[i];

                    // 手順6 nに、nをresult[i]で割った値を代入
                    n /= result[i];
                }

                // 手順5.result[i]で、nが割り切れなければ、iに1を足す
                else i++;

            // 手順7 nが1でなければ手順4に戻る
            } while (n != 1);

            // 手順8.pf[0]からpf[j]までの値を、素因数として出力する。
            System.out.println(num + ":" + 
                    java.util.Arrays.toString(java.util.Arrays.copyOfRange(pf, 0, j)));
        }
    }

    /** 
     * エラトステネスのふるい
     * @param N 上限値
     * @return 素数一覧
     */
    static int[] Eratosthenes(int N) {
        int[] data = new int[N + 1];
        int[] result = new int[N + 1];
        java.util.Arrays.fill(data, 1);
        data[0] = data[1] = 0;
        int n = 0;
        for (int m = 2; m <= N; m++) {
            if(data[m] == 0)continue;
            for (int i = 2 * m; i <= N; i += m) data[i] = 0;
            result[n++] = m;
        }
        return java.util.Arrays.copyOfRange(result, 0, n);
    }
}
