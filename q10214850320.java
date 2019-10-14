import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

class  Main {
    public static void main(String[] args) throws Exception {
        // ファイルを読み込んで、InfoBeanのリストを作る
        List<InfoBean> list = Files.lines(Paths.get("C:\\temp\\mondaibean.txt"))
            // カンマ区切りで分断
            .map(line -> line.split(","))
            // パラメータからInfoBeanを作る
            .map(params -> {
                InfoBean bean = new InfoBean();
                bean.name    = params[0];
                bean.address = params[1];
                bean.job     = params[2];
                bean.age     = params[3];
                return bean;})
           // Listに変換
            .collect(java.util.stream.Collectors.toList());

        // Listの内容を表示
        for (InfoBean bean : list) {
            System.out.println(bean.name + "\t" + bean.address + "\t" + bean.job + "\t" + bean.age);
        }
    }
}

/**
 * Beanを定義
 */
class InfoBean {
    // 名前、住所、仕事、年齢
    public String name, address, job, age;
}
