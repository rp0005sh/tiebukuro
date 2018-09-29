> # IntStreamの速度
> x1 =c(418,375,391,371,371,379,377,369,392,423)

> # Stream<Integer>変換型の速度
> x2 = c(2678,2603,2613,2593,2612,2593,2525,2553,2524,2563)

> t.test(x1, x2, alternative="less")

        Welch Two Sample t-test

data:  x1 and x2
t = -137.93, df = 12.089, p-value < 2.2e-16
alternative hypothesis: true difference in means is less than 0
95 percent confidence interval:
      -Inf -2170.701
sample estimates:
mean of x mean of y 
    386.6    2585.7
