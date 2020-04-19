import java.util.Scanner;

public class _11051 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long[][] dp = new long[n+1][k+1];
		
		for(int i=1; i<=n; i++)
		{
			for(int j=0; j<=Math.min(i, k); j++)
			{
				if(j == 0)
					dp[i][j] = 1;
				else if(j == 1)
					dp[i][j] = i;
				else
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				dp[i][j] %= 10007;
			}
		}
		System.out.println(dp[n][k]%10007);
	}
}