import static java.util.Arrays.*;

public class Main  {
  public static void main(String args[]) {
    // 初期化
    int[][] scores = new int[6][3];
    for (int[] score : scores) fill(score, -1);
    java.util.Scanner sc = new java.util.Scanner(System.in);

    // 入力処理
    for (int i = 0; i < scores.length; i++) {
      int num = readStudentNumber(sc, scores);
      scores[num - 1][0] = readScore(sc, "英語");
      scores[num - 1][1] = readScore(sc, "国語");
      scores[num - 1][2] = readScore(sc, "数学");
    }

    // 出力
    StringBuilder sb = new StringBuilder("番号 英語 数学 国語 合計 順位\n");
    for (int i = 0; i < scores.length; i++) {
      sb.append(i + 1).append(' ');                 // 番号
      stream(scores[i]).forEach(num -> sb.append(num).append(' '));  // 各教科
      sb.append(stream(scores[i]).sum()).append(' ')// 合計
      .append(rank(i, scores)).append('\n');        // 順位
    }
    System.out.println(sb.toString());
  }

  /**
   * 出席番号の入力を行う.
   * <p>
   * コマンドプロンプトから出席番号を入力してもらう.
   * 範囲外や重複する出席番号を入力した場合、再入力を促す.
   * </p>
   * @param sc スキャナー
   * @param scores スコア表
   * @return student_number 出席番号
   */
  static final int readStudentNumber(java.util.Scanner sc, int[][] scores) {
    int student_number;
    while (true) {
      System.out.print("番号を入力してください＞");
      student_number = sc.nextInt();
      if (student_number <= 0 || scores.length < student_number) {
        System.out.println("番号エラー");
        continue;
      } else if (scores[student_number - 1][0] != -1) {
        System.out.println("入力済番号");
        continue;
      }
      break;
    }
    return student_number;
  }

  /**
   * 教科の点数の入力を行う.
   * <p>
   * コマンドプロンプトから教科の点数を入力してもらう.
   * 範囲外を入力した場合、再入力を促す.
   * </p>
   * @param sc スキャナー
   * @param subject 教科名
   * @return score 点数
   */
  static final int readScore(java.util.Scanner sc, String subject) {
    int score;
    while (true) {
      System.out.print(subject + "の点数を入力してください＞");
      score = sc.nextInt();
      if (0 <= score && score <= 100) break;
      System.out.println("点数エラー");
    }
    return score;
  }

  /**
   * 順位を取得する.
   * <p>
   * 点数表から対象の出席番号の生徒の順位を取得する.
   * </p>
   * @param number 出席番号
   * @param scores 点数表
   * @return result 順位
   */
  static final int rank(int number, int[][] scores) {
    int  sum[], rank[], index = 0;
    sum = stream(scores).mapToInt(array -> -stream(array).sum()).toArray();
    sort(rank = sum.clone());
    while (rank[index++] < sum[number]);
    return index;
  }
}
