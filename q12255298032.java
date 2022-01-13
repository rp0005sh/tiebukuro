com.example.adaptertest.TwoColumnAdapter adapter =  new com.example.adaptertest.TwoColumnAdapter(this,R.layout.lv_adapter, userList);
listView = (ListView) findViewById(R.id.lv1);
listView.setAdapter(adapter);
listView.setOnItemClickListener((parent, view1, position, id) -> {
    User user = userList.get(userList.size() - 1 - position);
    long UserId = user.getId(); // ★IDの取得★
});
