import java.util.*;

class Main {
    public static void main(String[] args) {
        java.util.Random r = new java.util.Random();
        final int M = 10; // 平均来客時間[sec]
        final int L = 20; // 平均受付処理時間[sec]
        final int N = 2;  // 受付窓口の数

        int n[] = new int[N];                          // 各窓口の待ち時間
        Queue<Integer> wait_room = new ArrayDeque<>(); // 待合室(来客したらここで待つ)
        List<Integer> wait = new ArrayList<>();        // 各客の待ち時間
        List<Integer> wait_num = new ArrayList<>();    // 1秒周期における待合室の人の数

        // シミュレーション開始
        // 1秒周期ループを行い一日8時間勤務×5営業日(1週間のサンプルを収集する)
        for (int t = 0, cnt = r.nextInt(2 * M + 1); t < 60 * 60 * 8 * 5; t++) {

            // 来客処理
            if(cnt == 0) {
                // 来客カウンタが0になったら来客が来る
                cnt = r.nextInt(2 * M + 1); // 乱数で次の来客時間を設定
                wait_room.offer(t);         // 待合室に人を追加(来客時間を追加する)
            } else {
                // この時間に来客なし。来客カウンタを進める
                cnt--;
            }

            // 窓口に通す
            // 各窓口チェック
            for (int i = 0; i < N; i++) {
                // 窓口の処理カウンタが0なら、来客を受け入れることができる
                if (n[i] == 0) {
                    // 待合室に人がいるかチェック
                    Integer start = wait_room.poll();
                    if (start != null) {
                        // 人がいたので診断開始。待ってた時間を計算し、診断にかかる時間を設定
                        wait.add(t - start);
                        n[i] = r.nextInt(2 * L + 1);
                    } else {
                        // 待合室に人がいない場合は何もしない
                    }
                } else {
                    // まだ診断中の為、診断時間のカウンタを進める
                    n[i]--;
                }
            }

            // 一秒周期の待合室の人数をカウント
            wait_num.add(wait_room.size());
        }
        // シミュレーション終了

        // 計算
        System.out.println("待ってる平均時間 : " + wait.stream().mapToInt(Integer::intValue).average());
        System.out.println("待ってる人 : " + wait_num.stream().mapToInt(Integer::intValue).average());
    }
}
