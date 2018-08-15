> # レシートの金額(サンプルデータ)
> x = c(2160, 12940, 13975, 2160, 2160, 330,
+       2160, 10000, 5432, 2160, 330, 200,
+       128, 360, 1800, 100,2160, 2100, 360, 330)

> # ベンフォードのデータに変換
> ben = as.integer(x / 10^as.integer(log10(x)))

> # 1～9の範囲で1メモリ刻みのヒストグラムを取得
> xc = hist(ben, breaks = seq(0, 9, 1))$counts

> # ベンフォードの法則の分布
> ben_p = c()
> for(num in 1:9) ben_p = append(ben_p, log10(1 + 1 / num))

> # 適合度検定
> chisq.test(x = xc, p = ben_p)

        Chi-squared test for given probabilities

data:  xc
X-squared = 14.788, df = 8, p-value = 0.0634

 警告メッセージ: 
 chisq.test(x = xc, p = ben_p) で:   カイ自乗近似は不正確かもしれまん


> # 「カイ自乗近似は不正確かもしれまん」の対処法として、モンテカルロで適合度検定
> chisq.test(x = xc, p = ben_p, simulate.p.value=TRUE, B = 10000)

        Chi-squared test for given probabilities with simulated p-value
        (based on 10000 replicates)

data:  xc
X-squared = 14.788, df = NA, p-value = 0.06449
