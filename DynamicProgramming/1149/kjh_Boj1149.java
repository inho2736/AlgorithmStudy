import java.util.Scanner;

public class _1149 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n+1][3];
		
		for(int i=1; i<=n; i++)
			for(int j=0; j<3; j++)
				dp[i][j] = sc.nextInt();
		
		for(int i=2; i<=n; i++)
		{
			for(int j=0; j<3; j++)
			{
				int min = 1000000;
				for(int k=0; k<3; k++)
					if(j != k)
						min = Math.min(min, dp[i-1][k]);
				dp[i][j] += min;
			}
		}
		int res = 1000000;
		for(int i=0; i<3; i++)
			res = Math.min(res, dp[n][i]);
		System.out.println(res);
	}
}