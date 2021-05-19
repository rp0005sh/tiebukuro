class Main {
    public static void main(String[] args) {
        int day = new java.util.Scanner(System.in).nextInt();
        String sign;
        if (day <= 119)     sign = "やぎ座";     // 1月19日までは「やぎ座」
        else if(day <= 218) sign = "みずがめ座"; // 2月18日までは「みずがめ座」
        else if(day <= 320) sign = "うお座";     // 3月20日までは「うお座」
        else if(day <= 419) sign = "おひつじ座"; // 4月19日までは「おひつじ座」
        else if(day <= 520) sign = "おうし座";   // 5月20日までは「おうし座」
        else if(day <= 621) sign = "ふたご座";   // 6月21日までは「ふたご座」
        else if(day <= 722) sign = "かに座";     // 7月22日までは「かに座」
        else if(day <= 822) sign = "しし座";     // 8月22日までは「しし座」
        else if(day <= 922) sign = "おとめ座";   // 9月22日までは「おとめ座」
        else if(day <=1023) sign = "てんびん座"; //10月23日までは「てんびん座」
        else if(day <=1122) sign = "さそり座";   //11月22日までは「さそり座」
        else if(day <=1221) sign = "いて座";     //12月21日までは「いて座」
        else                sign = "やぎ座";     // 1月19日までは「やぎ座」
        System.out.println("あなたの星座は" + sign + "です。");
    }
}
