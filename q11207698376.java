public class test {
    public static void main(String[] args){
        int [][] sei = {
            {49, 50, 47, 58, 14, 58, 14, 89, 47, 69},
            {32, 26, 58, 59, 78, 99, 58, 58, 78, 58},
            {78, 22, 89, 69, 88, 25, 89, 68, 89, 99},
            {85, 89, 14, 99, 58, 56, 57, 69, 58, 58},
            {13, 96, 36, 10, 12, 25, 14, 25, 47, 14},
        };

        // 各教科の平均
        for (int i = 0; i < sei.length; i++) {
            int sum = 0, len = sei[i].length;
            for (int j = 0; j < len; j++)
                sum += sei[i][j];
            System.out.println(i + 1 + "番目の教科の平均点:" + (double)sum/len);
        }

        // 各人の平均
        double[] ave = new double[sei[0].length];
        for (int j = 0; j < sei[0].length; j++) {
            int sum = 0, len = sei.length;
            for(int i =0; i < len; i++)
                sum += sei[i][j];
            ave[j] = (double)sum / len;
            System.out.println(j + 1 + "番目の人の平均点:" + ave[j]);
        }

        // 偏差値
        double sum = 0, ssum = 0, var, sd;
        int num = sei[0].length;
        for (int i = 0; i < num; i++) {
            sum += ave[i];
            ssum += ave[i] * ave[i];
        }
        var = ssum/num - (sum/num) * (sum/num);           // V[X] = E[X^2] - (E[X])^2の公式
        sd = Math.sqrt(var);                              // 標準偏差は分散の平方根
        for (int i = 0; i < num; i++) {
            double t = 50 + 10 * (ave[i] - sum/num) / sd; // 偏差値(tスコア)とはX～N(50, 10^2)に従う分布
            System.out.println(i + 1 + "番目の人の偏差値:" + t);
        }
    }
}
