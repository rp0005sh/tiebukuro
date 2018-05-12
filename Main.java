// フォーカスのリスナーインスタンスを生成
View.OnFocusChangeListener listener = new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        TextView et = (TextView) v;
        if (hasFocus) {
            // フォーカスが当たってるときは、\と,は消す
            String text = et.getText().toString();
            et.setText(text.replaceAll("[¥,]", ""));
        } else {
            // フォーカスが外れたときは、\と,を挿入する
            String text = et.getText().toString();
            text = String.format("%,d", Integer.parseInt(text));
            et.setText("¥" + text);
        }
    }
};

// 各EditTextにリスナーの設定
for (int k = 0; k < 3; k++) {
    edittext[k].setOnFocusChangeListener(listener);
}

