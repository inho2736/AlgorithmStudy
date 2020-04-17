# [BAEKJOON / NO.9251] LCS

#### < 문제 >

LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

----

#### < 입출력 예제 >

입력 : 첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.

출력 : 첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.

* input : 

  ```
  ACAYKP
  CAPCAK
  ```

* output : 4

----

#### < 설명 >

dp[i] [j]는 입력받은 문자열2의  i번째까지의 부분문자열과 문자열1의 j번째까지의 부분문자열의 LCS의 길이를 나타낸다. (i, j 위치 바뀌어도 상관 없음)

예를 들어, 위 예제에서 dp[3] [2]는 CAPCAK의 부분문자열(i=3) **CAP**와 ACAYKP의 부분문자열(j = 2) **AC**의 LCS의 길이인 1을 저장하고 있다 (LCS = A 또는 C)

LCS의 길이는 두 문자가 같을 때 값이 증가한다. 이때 그 길이는 해당 문자가 포함되지 않았을 때의 최대길이 +1 이 된다. 즉, dp[i] [j] = dp[i-1] [j-1] +1이 최대값을 가진다.

(i-1은 문자열2에서 해당 문자가 포함되지 않은 경우이고, j-1은 문자열1에서 해당 문자가 포함되지 않은 경우이다.)

두 문자가 같지 않을 경우에는 지금까지 비교했던 경우 중에서의 최대값을 저장하면 누적하여 전체 최대값을 쉽게 찾을수 있다.

----

#### < 코드 >

```
import java.util.Scanner;

public class _9251 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		int[][] dp = new int[str2.length()+1][str1.length()+1];
		
		for(int i=1; i<=str2.length(); i++)
		{
			for(int j=1; j<=str1.length(); j++)
			{
				if(str2.charAt(i-1) == str1.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		System.out.println(dp[str2.length()][str1.length()]);
	}
}
```

