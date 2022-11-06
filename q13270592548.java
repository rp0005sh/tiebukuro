import java.util.stream.IntStream;
import java.util.Optional;
import java.util.Arrays;

class Main {
    public static void main(String args[]){
        int[][] testData = {
            null,         // Nullのテスト
            {1,2,3},      // 非Nullのテスト（平均が整数になる）
            {1,2,3,4,5,6},// 非Nullのテスト（平均が小数になる）
            {},           // 非Nullだけど要素がないテスト
        };
        
        for (int[] arr: testData) {
            System.out.printf("%n■引数%sの場合%n", Arrays.toString(arr));
            System.out.printf("average：%.2f%n", agerage(arr));
        }
    }
    
    static double agerage(int[] arr){
        return Optional.ofNullable(arr).map(IntStream::of)
        .map(s -> s.peek(System.out::println).average().orElse(0))
        .orElse(0d);
    }
}
