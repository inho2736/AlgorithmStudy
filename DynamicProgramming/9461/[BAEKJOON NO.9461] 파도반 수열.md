# [BAEKJOON NO.9461] 파도반 수열

#### < 문제 >

그림과 같이 삼각형이 나선 모양으로 놓여져 있다. 첫 삼각형은 정삼각형으로 변의 길이는 1이다. 그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다. 나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다. 파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다. P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다. N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.

![1586411171188](C:\Users\Kim JiHye\AppData\Roaming\Typora\typora-user-images\1586411171188.png)

------

#### < 입출력 예제 >

입력 : 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다.

(1 ≤ N ≤ 100)

출력 : 각 테스트 케이스마다 P(N)을 출력한다.

* input : 2 6 12        output : 3 16

------

#### < 설명 >

규칙은 다음과 같다.

1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12...

즉, N>=6 일때 f(x) = f(x-1) + f(x-5)

------

#### < 코드 >

```
import java.util.Scanner;

public class _9461 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for(int i=0; i<test; i++)
        {
            int n = sc.nextInt();
            long[] dp = new long[n+1];

            for(int j=1; j<=n; j++)
            {
                if(j <=3)
                    dp[j] = 1;
                else if(j <=5)
                    dp[j] = 2;
                else
                    dp[j] = dp[j-1] + dp[j-5];
            }
            System.out.println(dp[n]);
        }
    }
}
```

