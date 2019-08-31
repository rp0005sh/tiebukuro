class Main {
    public static void main(String[] args) {
        // 入力処理
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("整数A : ");
        int A = sc.nextInt();
        System.out.print("整数B : ");
        int B = sc.nextInt();
        
        // どっちが大きいかif文で判定
        int max,min;
        if (A < B) {
            max = B;
            min = A;
        } else {
            max = A;
            min = B;
        }

        // 全整数を小さいほうから順に表示する
        while (min <= max) {
            System.out.print(min + " ");
            min++;
        }
    }
}
