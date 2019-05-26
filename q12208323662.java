import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.print("ユーザの数値入力 > ");
        Scanner sc = new Scanner(System.in);
        int num1= sc.nextInt();

        while (true) {
            // 乱数0～100の乱数を生成
            int rdm = (int) (Math.random() * 101);

            // 評価
            int input = num1;
            if (input > rdm) {
                System.out.println("大きい");
            } else if(input < rdm) {
                System.out.println("小さい");
            } else {
                System.out.println("同じ");
                break; // 「同じ」ならループを抜ける
            }
        }
    }
}
