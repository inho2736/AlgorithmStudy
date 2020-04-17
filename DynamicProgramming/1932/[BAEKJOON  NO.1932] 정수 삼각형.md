# [BAEKJOON / NO.1932] 정수 삼각형

#### < 문제 >

```
        7
      3   8
    8   1   0
  2   7   4   4
4   5   2   6   5
```

위 그림은 크기가 5인 정수 삼각형의 한 모습이다.

맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라. 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.

삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.

---

#### < 입출력 예제 >

입력 : 첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.

출력 : 첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력한다.

* input : 

  ```
  5
  7
  3 8
  8 1 0
  2 7 4 4
  4 5 2 6 5
  ```

* output : 30

----

#### < 설명 >

삼각형을 이차원 배열에 입력받을 때, dp[i] [j]는 dp[i+1] [j] 또는 dp[i+1] [j+1]에 더해질 수 있다.

바꿔 말하면 dp[i] [j] 에 더해질 수 있는 값은 dp[i-1] [j-1]과 dp[i-1] [j]이다.

선택된 수의 합이 최대가 되기 위해서는 dp[i-1] [j-1]과 dp[i-1] [j] 두 값 중에서 더 큰 값을 더하며 내려오면 된다.

즉, 점화식은 dp[i] [j] = dp[i] [j] + max(dp[i-1] [j-1], dp[i-1] [j])

----

#### < 코드 >

```
import java.util.Scanner;

    public class _1932 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n+1][n+1];

        for(int i=1; i<=n; i++)
            for(int j=1; j<=i; j++)
                dp[i][j] = sc.nextInt();

        for(int i=2; i<=n; i++)
            for(int j=1; j<=i; j++)
                dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);

        int res = 0;
        for(int i=1; i<=n; i++)
            res = Math.max(res, dp[n][i]);
        System.out.println(res);
    }
}
```

