import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String args[]){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("入力数を入れてください->");
        int n = sc.nextInt();
        Queue<String> queue = new LinkedList<>();

        // 登録していく
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "つ目-> ");
            String tmp = sc.next();
            System.out.println("Queue(offer):" + tmp);
            queue.offer(tmp);
        }
        
        // 中身を全部出して良く
        for (int i = 0; i < n; i++) {
            String tmp = queue.poll();
            System.out.println("Queue(poll):" + tmp);
        }
    }

}
