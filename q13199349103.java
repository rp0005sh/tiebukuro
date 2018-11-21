import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import javax.swing.table.TableColumn;
import javax.swing.table.JTableHeader;

/** テーブルでカレンダーを作る */
public class MyFrame extends JFrame {
  /** カラム名(ヘッダに表示させる) */
  private final String[] columnNames = {"月", "火", "水", "木", "金", "土", "日"};
  /** テーブルに表示させる */
  private final String[][] tabledata = {
    {"1", "2", "3", "4", "5", "6", "7"},
    {"8", "9", "10", "11", "12", "13", "14"},
    {"15", "16", "17", "18", "19", "20", "21"},
    {"22", "23", "24", "25", "26", "27", "28"},
    {"29", "30", "31", "", "", "", ""},
  };

  public static void main(String[] args) {
    MyFrame test = new MyFrame("SwingTest");
    test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    test.setVisible(true);
  }

  MyFrame(String title) {
    super(title);
    setBounds( 10, 10, 300, 200);

    JTable table = new JTable(tabledata, columnNames);
    getContentPane().add(new JScrollPane(table));

    // ヘッダ部位にマウス操作アクションを設定
    table.getTableHeader().addMouseListener(action);
  }

    /**
     * マウスでテーブルのヘッダ押下したときのイベント処理
     */
    MouseAdapter action = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            // Eventからクリックするcolumnを取得
            JTableHeader header = (JTableHeader)e.getSource();
            TableColumn column = (TableColumn) header.getDraggedColumn();

            // 要素番号、文言を取得
            int index = column.getModelIndex();
            String value = (String) column.getHeaderValue();

            System.out.printf("要素番号:%d, 文言:%s\n", index, value);
        }
    };
}
