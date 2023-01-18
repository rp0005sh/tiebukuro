val lvMenu = findViewById<ListView>(R.id.lvMenu)
val adapter = object:SimpleAdapter(this@MainActivity, menuList, android.R.layout.simple_list_item_2, from, to) {
  override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
    val view = super.getView(position, convertView, parent)
    view.findViewById<TextView>(android.R.id.text1).setTextColor(Color.WHITE) // 1段目の色設定
    view.findViewById<TextView>(android.R.id.text2).setTextColor(Color.WHITE) // ２段目の色設定
    return view
  }
}
lvMenu.adapter = adapter
