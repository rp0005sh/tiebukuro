class Main {
    public static void main(String[] args) {

        // 準備
        int[] array1 = {88, 68, 45, 69, 85};
        String[] array2 = {"no1", "no2", "no3", "no4", "no5"};
        int[] index = new int[array1.length];
        for(int i = 0; i < index.length; i++) index[i] = i;

        // ソート(Bubble Sort)
        for(int i = 0; i < index.length; i++){
            for(int j = 0; j< index.length -i -1; j ++){
                if(array1[index[j]] < array1[index[j] + 1]){
                    int temp = index[j];
                    index[j] = index[j + 1];
                    index[j + 1] = temp;
                }
            }
        }

        // 結果出力
        System.out.println("昇順");
        for(int i:index) System.out.println(array2[i] + " " + array1[i]);
    }
}
