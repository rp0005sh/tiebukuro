import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        String num = scan.next();
        String kanma = ",";
        String removerRange = "-";
        String[] split = num.split(",", -1);
        String[] fromTo = num.split("-", -1);

        for (int i = 0; i < split.length; i++) {
            //ハイフン区切り
            if (split[i].contains(removerRange)) {
                fromTo = split[i].split("-", -1);
                int x = Integer.parseInt(fromTo[0]);
                int y = Integer.parseInt(fromTo[1]);
                for (int j = x; j <= y; j++)
                    list.add(j);
            }
            //カンマ区切り
            else {
                list.add(Integer.parseInt(split[i]));
            }
        }

        for (int i = 0; i < 5; i++) {
            // System.out.print((i + 1) + " ");
            for (int j = 0; j < 10; j++) {
                // 乱数生成
                Random rnd = new Random();
                int rand = rnd.nextInt(100) + 1;

                if (!list.contains(rand)) { // 今までに出たことが無い数のとき
                    // リストに追加
                    list.add(rand);
                    // 出力
                    System.out.print(rand + ",");
                } else { // 今までに出たことがある数のとき
                    // もう一度やりなおし
                    j--;
                }
            }
            Collections.sort(list);
            System.out.println();
        }
    }
}
