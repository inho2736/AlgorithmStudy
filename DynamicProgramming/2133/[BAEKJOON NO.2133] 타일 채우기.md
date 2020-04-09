# [BAEKJOON NO.2133] 타일 채우기

#### < 문제 >

3xN 크기의 벽을 2x1, 1x2 크기의 타일로 채우는 경우의 수를 구해보자

------

#### < 입출력 예제 >

입력 : 첫째 줄에 N(1 <= N <= 30) 이 주어진다.

출력 : 첫째 주에 경우의 수를 출력한다.

* input : 2        output : 3

------

#### < 설명 >

먼저 2x1과 1x2 블록으로 N이 홀수인 벽을 채울 수 있는 방법은 없다.

N이 짝수일 때,

1. N = 2일때 : 3가지



![1586409143407](C:\Users\Kim JiHye\AppData\Roaming\Typora\typora-user-images\1586409143407.png)

2. N = 4일때 : 3x3 + 2 = 9 + 2 = 11가지 ( N=2 x N=2일때 + 특이case 2개 )

![1586409614846](C:\Users\Kim JiHye\AppData\Roaming\Typora\typora-user-images\1586409614846.png)

3. N = 6일때 :  11x3 + 2x3 + 2 = 33 + 6 + 2 = 41 ( N=4 x N=2일때 + N=2 x N=4의 특이case + 특이case 2개 )
   * 첫번째 경우에 N=2가 오른쪽에 붙은 경우를 포함한다면 두번째 경우는 N=2가 왼쪽에 붙었을때를 나타냄

![1586410773421](C:\Users\Kim JiHye\AppData\Roaming\Typora\typora-user-images\1586410773421.png)

4. N = i일때 : N=N-2 * N=2 + 2* (N=2, 4, 6...N-4) + 2

------

#### < 코드 >

```
import java.util.Scanner;

public class _2133 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n%2 == 1)
            System.out.println(0);
        else
        {
            int[] dp = new int[n+1];
            dp[0] = 1;

            for(int i=2; i<=n; i+=2)
            {
                dp[i] = dp[i-2]*3;

                for(int j=0; j<=i-4; j+=2)
                    dp[i] += dp[j]*2;
            }	
            System.out.println(dp[n]);
        }
    }
}
```

