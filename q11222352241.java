import java.security.MessageDigest;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String msg1 = "あいうえお";
        String msg2 = "かきくけこ";

        // 「あいうえお」をSHA-256変換する
        md.update(msg1.getBytes());
        byte[] b1 = md.digest();
        System.out.println(msg1 + ":" + toHex(b1));

        // 「かきくけこ」をSHA-256変換する
        md.update(msg2.getBytes());
        byte[] b2 = md.digest();
        System.out.println(msg2 + ":" + toHex(b2));

        // それぞれを整数にして足し合わせる。その後、16進数にする
        BigInteger bi1 = new BigInteger(toHex(b1), 16);
        BigInteger bi2 = new BigInteger(toHex(b2), 16);
        System.out.println("足し合わせのハッシュ値：" + bi1.add(bi2).toString(16));
    }

    // バイト配列を16進数表記文字にする
    static String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte d : bytes) sb.append(String.format("%02x", d));
        return sb.toString();
    }
    
}
