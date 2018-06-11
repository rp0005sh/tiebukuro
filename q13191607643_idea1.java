MainActivityのloadSumを以下に修正

    private void loadSum() {
        dbAdapter.openDB(); // DBの読み込み(読み書きの方)
        int amount;
        // DBのデータを取得
        Cursor c = dbAdapter.getSumData(DBAdapter.COL_PRICE);
        if (c.moveToFirst()) {
            do {
                amount = c.getInt(0);
                Text01Sum.setText(amount);
            } while (c.moveToNext());
        }

        c.close();
        dbAdapter.closeDB(); // DBを閉じる
    }
    
    

DBAdapterに以下のメソッド追加
    /**
     * カラムの合計値を取得
     * @param column 合計値を取得したいカラム名
     * @return DBのデータ
     */
    public Cursor getSumData(String column) {
        return db.rawQuery("select sum(" + column + ") from " + DB_TABLE +";", null);
    }
