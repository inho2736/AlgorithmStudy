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
		
		/*
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
		System.out.println(res % 9901);
		*/
	}
}