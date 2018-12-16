class Main {
    public static void main(String args[]) {
        java.util.Random r = new java.util.Random();
        int[] arr;

        // すべて異なる値が取れるまでループさせる
        do {
            arr = r.ints(4, 0, 10).toArray();
        } while(isSameElement(arr));

        // 要素表示
        System.out.println(java.util.Arrays.toString(arr));
    }

    /**
     * 配列の要素に同じものがないかをチェックする
     * @param arr チェック対象の配列
     * @return true:同じ要素がある。false:同じ要素がない
     */
    static boolean isSameElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] == arr[j]) return true;
            }
        }
        return false; 
    }
}

