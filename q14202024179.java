public class Main {
    public static void main(String[] args) throws javax.script.ScriptException {
        // エンジン起動
        javax.script.ScriptEngineManager manager = new javax.script.ScriptEngineManager();
        javax.script.ScriptEngine engine = manager.getEngineByName("nashorn");

        // 演算子を配列で定義(割り算パターン必要なら、この配列に追加する)
        char[] op = {'+', '-', '*',};

        // ループで全通り試す
        for (char op1 : op) {
            for (char op2 : op) {
                for (char op3 : op) {
                    for (char op4 : op) {
                        // 数式を組み立てる
                        String formula = String.format("%d %c %d %c %d %c %d %c %d", 1, op1, 2, op2, 3, op3, 4, op4, 5);
                        // 計算して出力
                        System.out.println(formula + " = " + engine.eval(formula));
                    }
                }
            }
        }
    }
}
