# [BAEKJOON / NO.11057] 오르막 수

#### < 문제 >

오르막 수는 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.

예를 들어, 2234와 2378, 11110는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.

수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.

------

#### < 입출력 예제 >

입력 : 첫째 줄에 N( 1 <= N <= 1,000 )이 주어진다.

출력 : 첫째 줄에 길이가 N인 오르막 수의 개수를 10,007로 나눈 나머지를 출력한다.

* input : 1		output : 10
* input : 2        output : 55
* input : 3        output : 220

------

#### < 설명 >

수의 길이 N이 주어졌을 때, i번째 자리 수는 i-1번째 자리 수와 같거나 +1인 수이다.

예를 들어, arr[3] [3]의 값을 구해보자.

이는 N=3이고 마지막 숫자가 3인때의 오르막 수의 개수를 나타낸다.

세자리 숫자를 xy3이라고 할 때, y가 될 수 있는 경우는 3, 2, 1, 0 총 4가지 이다.

이때 y=3일 경우는 N=2일 때, 즉 두자리 숫자 a33일 경우이고 이는 arr[2] [3]의 값과 같다.

그리고 y=2,1,0일 경우는 세자리 숫자 ab2일 때 와 같은 숫자들이 나오고 이는 arr[3] [2]의 값과 같다

이를 점화식으로 나타내면,

arr[i] [j] = arr[i-1] [j] + arr[i] [j-1] 이 된다.

------

#### < 코드 >

```
import java.util.Scanner;

public class _11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][10];
        int res = 0;

        for(int i=0; i<=9; i++)
            arr[1][i] = 1;

        for(int i=2; i<=n; i++)
        {
            for(int j=0; j<=9; j++)
            {
                if(j == 0)
                    arr[i][j] = 1;
                else
                    arr[i][j] = arr[i][j-1] + arr[i-1][j];
                arr[i][j] %= 10007;
            }
        }
        for(int i=0; i<=9; i++)
            res += arr[n][i];
        System.out.println(res%10007);
	}
}
```

