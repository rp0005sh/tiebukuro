import java.util.Random;

class Main {
    
    public static void main(String[] args) {
        int num[] = new int[53];
        Random r = new Random();
        for (int i = 1; i < 53; i++) {
            num[i] = i;
        }
        for (int j = 1; j < 6; j++) {
            int index = r.nextInt(52) + 1;
            int num1 = num[index];
            num[index] = -1; // 重複チェックのため、使用した要素は「-1」にして破棄

            // 重複していた場合
            if (num1 == -1) {
                j--; // ループカウンターをなかったことに
                continue; // やり直し
            }

            System.out.print(num1 + ", ");
        }
    }
}
