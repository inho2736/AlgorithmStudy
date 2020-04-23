[BAEKJOON / NO.1309] 동물원

#### < 문제 >

어떤 동물원에 가로로 두칸 세로로 N칸인 아래와 같은 우리가 있다.

![img](https://www.acmicpc.net/upload/201004/dnfl.JPG)

이 동물원에는 사자들이 살고 있는데 사자들을 우리에 가둘 때, 가로로도 세로로도 붙어 있게 배치할 수는 없다. 이 동물원 조련사는 사자들의 배치 문제 때문에 골머리를 앓고 있다.

동물원 조련사의 머리가 아프지 않도록 우리가 2*N 배열에 사자를 배치하는 경우의 수가 몇 가지인지를 알아내는 프로그램을 작성해 주도록 하자. 사자를 한 마리도 배치하지 않는 경우도 하나의 경우의 수로 친다고 가정한다.

----

#### < 입출력 예제 >

입력 : 첫째 줄에 우리의 크기 N(1≤N≤100,000)이 주어진다.

출력 : 첫째 줄에 사자를 배치하는 경우의 수를 9901로 나눈 나머지를 출력하여라.

* input : 4
* output : 41

----

#### < 설명 >

* 메모리초과로 인해 실패한 코드 설명

  dp[i] [j] = N이 i일때 사자 j마리를 배치하는 경우의 수

  dp[i] [j] = dp[i-2] [j-1] + dp[i-1] [j-1] + dp[i-1] [j]

  

  예시) dp[5] [3] : N이 5일때 사자 3마리를 배치하는 경우의 수

  이 값은 먼저 새로 추가된 한줄에 사자가 배치되지 않는 경우와 배치되는 경우로 나눌 수 있다.

     - 추가된 한줄에 사자가 배치되지 않는 경우 : dp[4] [3]

     - 추가된 한줄(노란색)에 사자가 배치되는 경우 : dp[4] [2] + dp[3] [2]

       ![1587473350173](C:\Users\Kim JiHye\AppData\Roaming\Typora\typora-user-images\1587473350173.png)

       추가된 한줄을 제외하고 생각할때, 빨간색 X의 경우가 중복된다.

       이 중복된 경우는 dp[3] [2]의 경우와 같다

       

* 성공한 코드 설명

  위의 방법으로 N = 5일때의 답을 구할때, 각 원소가 더해지는 횟수는 다음과 같다

  ![1587473929371](C:\Users\Kim JiHye\AppData\Roaming\Typora\typora-user-images\1587473929371.png)

  이때, i < j 인 곳은 그 값이 0이므로 아래와 같이 나타낼 수 있다.

  ![1587473985303](C:\Users\Kim JiHye\AppData\Roaming\Typora\typora-user-images\1587473985303.png)

  마지막으로 모든 dp[i] [0]의 값은 1로 동일 하므로 아래와 같이 나타낼 수 있다.

  ![1587474029717](C:\Users\Kim JiHye\AppData\Roaming\Typora\typora-user-images\1587474029717.png)

  즉, dp[i] = dp[i-2] + 2 * dp[i-1] 로 일차원 배열로 풀 수 있다. ( i > 2)

-----

#### < 코드 >

* 성공 코드

```
import java.util.Scanner;

public class _1309 {

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int[] dp = new int[n+1];
	
	for(int i=1; i<=n; i++)
	{
		if(i == 1)
			dp[i] = 3;
		else if(i == 2)
			dp[i] = 7;
		else
			dp[i] = dp[i-2] + 2 * dp[i-1];
		
		dp[i] %= 9901;
	}
	System.out.println(dp[n]);
}
```



* 메모리 초과로 인해 실패한 코드

```
import java.util.Scanner;

public class _1309 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n+1][n+1];

        for(int i=0; i<=n; i++)
            dp[i][0] = 1;

        dp[1][1] = 2;
        for(int i=2; i<=n; i++)
            for(int j=1; j<=i; j++)
                dp[i][j] = dp[i-2][j-1] + dp[i-1][j-1] + dp[i-1][j];

        long res = 0;
        for(int i=0; i<=n; i++)
            res += dp[n][i] % 9901;
        System.out.println(res);
    }
}
```

