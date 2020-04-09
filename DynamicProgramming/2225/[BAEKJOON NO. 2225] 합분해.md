# [BAEKJOON NO. 2225] 합분해

#### < 문제 >

0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오. 덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.

------

#### < 입출력 예제 >

입력 : 첫째 줄에 두 정수 N(1 ≤ N ≤ 200), K(1 ≤ K ≤ 200)가 주어진다.

출력 :  첫째 줄에 답을 1,000,000,000으로 나눈 나머지를 출력한다.

* input : 20 2			output : 21

------

#### < 설명 >

이차원 배열 arr[i] [j]에서 arr의 각 행은 더해지는 수의 갯수(K) 를 나타내고 열은 만들어지는 수(N)을 나타낸다.

arr[1]행은 하나의 수로 N을 만들 수 있는 방법을 말하는데 그 값은 자기자신 하나 뿐이므로 모두 1이다.

K=i일때 j을 만들 수 있는 방법은, 마지막으로 추가된 숫자(z)가 0~n일때를 모두 더한 값이다.

* z = 0 일때 : i-1개의 수로 j을 만드는 경우 = arr[i-1] [j]

* z = n~1일때 : i-1개의 수로 0~j-1을 만드는 경우 = arr[i-1] [0 ~ j-1] = arr[i] [j-1]



ex) arr[3] [3], 세개의 숫자 x, y, z인 경우

​	z = 0		 :	x+y = 3		  : 	arr[2] [3]

​	z = 1...3	:	**x+y = 2...0**	:	 arr[2] [2...0]

​	arr[3] [2], 세개의 숫자 x, y, z인 경우

​	z = 0...2	:	**x+y = 2...0**

즉,  arr[i-1] [0...j-1]의 경우는  arr[i] [j-1]의 경우와 같다 ( 단, z의 값은 다름 ) 

------

#### < 코드 >

```
import java.util.Scanner;

public class _2225 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[][] dp = new long[k+1][n+1];

        for(int i=0; i<=n; i++)
            dp[1][i] = 1;

        for(int i=2; i<=k; i++)
        {
            for(int j=0; j<=n; j++)
            {
                if(j == 0)
                    dp[i][j] = 1;
                else
                {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                    dp[i][j] %= 1000000000;
                }

            }
        }
        System.out.println(dp[k][n] % 1000000000);
    }
}
```

