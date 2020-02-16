import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

class Main {
    public static void main(String[] args) throws Exception {
        // ファイル読み込み
        ArrayList<String> list = function1("tennsuu.text");

        // 人数
        int cnt = function2(list);
        System.out.println("人数\t: " + cnt);

        // 各教科の平均出力
        for (String subject : new String[] {"kokugo","sansuu","rika","syakai"}) {
            int sum = function3(list, subject);
            System.out.printf("%s\t: %d%n", subject, function4(sum, cnt));
        }
    }

    /** 機能① ファイル読み込み機能 */
    private static ArrayList<String> function1(String path) throws java.io.IOException {
        return new ArrayList<String>(Files.readAllLines(Paths.get(path)));
    }
    
    /** 機能② 人数を数える機能 */
    private static int function2(ArrayList<String> list) {
        return (int) list.stream().filter(s -> s.equals("deta")).count();
    }
    
    /* 機能③ 指定した教科の合計点を出す機能 */
    private static int function3(ArrayList<String> list, String subject) {
        return (int) list.stream().filter(s -> s.startsWith(subject))
            .map(sub -> sub.split(":")[1]).mapToInt(Integer::parseInt).sum();
    }

    /* 機能④ 割り算機能 */
    private static int function4(int n1, int n2) {
        return n1 / n2;
    }
}
