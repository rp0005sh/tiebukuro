import java.util.*;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long count;                // ｘのカウンタ
		String target = sc.next(); // 入力される文字

		// 1. stramでフィルタかけて数える
		count = target.chars().filter(c -> c == 'x').count();
		System.out.println("1. count = " + count);

		// 2. 「y」を消す文字列置換すると「x」だけの文字列になるので、文字数を数える
		count = target.replace("y","").length();
		System.out.println("2. count = " + count);

		// 3.連立方程式を解く
		count = (target.chars().sum() - 'y' * 5) /('x' - 'y');
		System.out.println("3. count = " + count);

		// 4. 拡張for文で一文字ずつ数える
		count = 0;
		for (char c : target.toCharArray()) if ('x' == c) count++;
		System.out.println("4. count = " + count);

		// 5.通常for文で一文字ずつ数える
		count = 0;
		for(int i = 0; i < 5; i++) if('x' == target.charAt(i)) count++;
		System.out.println("5. count = " + count);
	}
}

