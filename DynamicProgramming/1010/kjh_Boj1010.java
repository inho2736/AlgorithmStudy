import java.util.Scanner;

public class _1010 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		while(test > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			long[][] dp = new long[n+1][m+1];
			
			if(n == 1)
			{
				System.out.println(m);
				test--;
				continue;
			}
			
			for(int i=1; i<=n; i++)
			{
				if(i == 1)
					for(int j=i; j<=m; j++)
						dp[i][j] = 1;
				else if(i == 2)
					for(int j=i; j<=m; j++)
						dp[i][j] = dp[i][j-1] + j-1;
				else
					for(int j=i; j<=m; j++)
						dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
			}
			System.out.println(dp[n][m]);
			test--;
		}
	}
}