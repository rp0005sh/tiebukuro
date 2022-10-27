import java.util.concurrent.CountDownLatch;
import java.util.Scanner;

class Main {
    public static void main(String args[]) throws Exception{
        CountDownLatch cdl = new CountDownLatch(1);

        // スレッド定義
        class MyThread extends Thread {
            final String id, password;
            MyThread(String id, String password) {
                this.id = id;
                this.password = password;
            }

            @Override public void run() {
                if(id.equals("admin") && password.equals("1234")) {
                    System.out.println("認証に成功しました");
                }else {
                    System.out.println("認証が失敗しました");
                }
                cdl.countDown();
            }
        }
        
        // ユーザに入力させる
        Scanner sc = new Scanner(System.in);
        System.out.print("id > ");
        String id = sc.nextLine();
        System.out.print("password > ");
        String password = sc.nextLine();
        
        // 認証スレッド起動させて、処理が終わるまで待つ
        new MyThread(id,password).start();
        cdl.await();
        System.out.print("認証スレッドが終了しました");
    }
}
