import java.util.Scanner;

public class _11048 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] dp = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
				dp[i][j] = sc.nextInt();
		
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=m; j++)
			{
				if(j == 1)
					dp[i][j] += dp[i-1][j];
				else
					dp[i][j] += Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], dp[i-1][j]));
			}
		}
		System.out.println(dp[n][m]);
	}
}