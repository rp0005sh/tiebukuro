fun main(args: Array<String>) {

    // 問題文生成（二次元配列とし、1行が{問題文、回答番号}の配列とする
    val quiz = arrayOf(
        arrayOf("コアラの大好きなユーカリの葉には、あるものが含まれています。いったい何でしょう？1.アルコール 2.ビタミンC 3.猛毒（もうどく）", "3"),
        arrayOf("XXXXX", "3"),
        arrayOf("YYYYY", "3")
    )

    // 出題する問題番号Indexを重複しない乱数で生成
    val q_index = java.util.Random().ints(0, quiz.size).distinct().limit(3).toArray()

    // 正解数のカウンタ
    var ans_cnt = 0
    
    // 問題の出題と回答をループで実行
    for (i in 0..2) {

        // 出題
        val q = q_index[i]
        println("Q${i+1}.${quiz[q][0]}")

        // 回答受付、正解と比較
        if (quiz[q][1] == readLine()!!) {
            println("正解です！")
            ans_cnt++
        } else {
            println("不正解です。")

        }
        println()
    }
    
    // 最終結果の表示
    println("これでクイズは終了です。3問中$ans_cnt 問正解でした。")

    
}
