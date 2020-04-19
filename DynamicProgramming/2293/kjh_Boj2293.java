import java.util.Scanner;

public class _2293 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coin = new int[n+1];
		int[][] dp = new int[n+1][k+1];
		
		for(int i=1; i<=n; i++)
			coin[i] = sc.nextInt();
		
		for(int i=1; i<=n; i++)
		{
			for(int j=0; j<=k; j++)
			{
				if(j == 0)
					dp[i][j] = 1;
				else
				{
					if(j < coin[i])
						dp[i][j] = dp[i-1][j];
					else
						dp[i][j] = dp[i-1][j] + dp[i][j-coin[i]];
				}
					
			}
		}
		System.out.println(dp[n][k]);
	}
}