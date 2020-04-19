import java.util.*;
public class _2167 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [][] arry = new int[n+1][m+1];
		int [][] dp = new int [n+1][m+1];
		for (int i = 1; i<=n;i++)
		{
			for(int j = 1; j<=m; j++)
			{
				arry[i][j] = sc.nextInt();
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arry[i][j]; 
			}
		}
		int k = sc.nextInt();
		
		for (int a = 1; a<=k; a++)
		{
			int i = sc.nextInt();
            int j = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            System.out.println(dp[x][y] - dp[i - 1][y] - dp[x][j - 1] + dp[i - 1][j - 1]);

		}
		
	}

}
