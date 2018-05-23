public class Roll {
  public static void main(String[] args) {

    // コマンドライン引数の数をチェックして足りなければエラーを表示
    if (args.length < 4) {
        System.out.println("正しい個数のコマンドライン引数を与えてください");
        System.exit(1);
    }

    // コマンドライン引数から情報を取得する
    Info info = new Info(args[0], args[1], args[2], args[3]);

    // 表示する
    System.out.println(info);
  }
}

/**
 * 個人情報クラス
 */
final class Info {
    final public String name, zip, address, phone;
    Info(String name, String zip, String address, String phone) {
        this.name = name;
        this.zip = zip;
        this.address = address;
        this.phone = phone;
    }
    
    @Override public String toString() {
        return new StringBuilder()
            .append("名前＝ ").append(name).append('\n')
            .append("〒＝ ").append(zip).append('\n')
            .append("住所＝ ").append(address).append('\n')
            .append("電話＝ ").append(phone).toString();
    }
}
