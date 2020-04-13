import java.util.Scanner;

public class _11052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++)
			dp[0][i] = sc.nextInt();
		
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=i; j++)
			{
				if(i == j)
					dp[i][j] = dp[0][j];
				else
				{
					int max = 0;
					for(int k=1; k<=i-j; k++)
						if(dp[i-j][k] > max)
							max = dp[i-j][k];
					dp[i][j] = max + dp[0][j];
				}
			}
		}
		int res = 0;
		for(int i=1; i<=n; i++)
			res = Math.max(res, dp[n][i]);
		System.out.println(res);
	}
}