import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[]scores = new int[10];
        for(int i = 0; i<scores.length; i++) {
            System.out.println((i+1) + "人目の整数を入力してください");
            scores[i]=sc.nextInt();
        }

        // 平均を求める
        double ave = java.util.Arrays.stream(scores).average().getAsDouble();
        System.out.println("平均：" + ave);
        
        // 平均を上回る人数を求める
        long cnt = java.util.Arrays.stream(scores).filter(n -> n >= ave).count();
        System.out.println("平均を上回る人数：" + cnt);
    }
}
