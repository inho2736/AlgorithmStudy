import java.util.Scanner;

public class _1699 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[(int)Math.sqrt(n)+1][n+1];
		
		for(int i=1; i<=n; i++)
			dp[1][i] = i;
		
		for(int i=2; i<dp.length; i++)
		{
			for(int j=1; j<i*i; j++)
				dp[i][j] = dp[i-1][j];
			
			int tmp = i*i;
			for(int j=i*i; j<=n; j++)
			{
				if(j == tmp)
				{
					dp[i][j] = tmp/(i*i);
					tmp += i*i;
				}
				else
					dp[i][j] = dp[i][tmp-i*i] + dp[i-1][j-(tmp-i*i)];
				
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j]);
			}
		}
		System.out.println(dp[(int)Math.sqrt(n)][n]);
	}
}