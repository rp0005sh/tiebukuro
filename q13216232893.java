class  Main {
    public static void main(String[] args) throws Exception {
        // System.out.print()の出力先を「05out.txt」ファイルにする
        System.setOut(new java.io.PrintStream("05out.txt"));

        // ファイル読み込み、コレクションにする
        java.util.List<String> list = 
            java.nio.file.Files.readAllLines(java.nio.file.Paths.get("05list.txt"));

        // 並び替え（昇順）
        list.stream().mapToInt(Integer::parseInt)
        .sorted()
        // ファイルに出力させる
        .forEach(System.out::println);
    }
}
