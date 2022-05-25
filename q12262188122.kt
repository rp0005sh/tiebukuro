        // TabLayout、ViewPager2取得
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2 = findViewById<ViewPager2>(R.id.pager)

        // 紐づける
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            // タブの領域にTextViewを置く為に生成
            val tv = TextView(this)
            tv.text = "OBJECT ${(position + 1)}" // 文言は適当
            // タブにはめ込む
            tab.customView = tv

            // TextViewに押下イベントを入れる。ここで、ダイアログを出す制御
            tv.setOnClickListener {
                AlertDialog.Builder(this) .setTitle("タブ遷移します")
                    .setMessage("切り替えていいですか")
                    .setPositiveButton("OK") { _, _ ->
                        // OKが押されたらタブを切り替える
                        tab.select()
                    }
                    .setNegativeButton("No") { _, _ ->
                        // TODO:Noが押された時の挙動。何もしたくない？
                    }
                    .show()
            }
        }.attach()
