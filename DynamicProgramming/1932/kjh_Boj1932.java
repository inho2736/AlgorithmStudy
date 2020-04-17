import java.util.Scanner;

public class _1932 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++)
			for(int j=1; j<=i; j++)
				dp[i][j] = sc.nextInt();
		
		for(int i=2; i<=n; i++)
			for(int j=1; j<=i; j++)
				dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
		
		int res = 0;
		for(int i=1; i<=n; i++)
			res = Math.max(res, dp[n][i]);
		System.out.println(res);
	}
}