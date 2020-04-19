import java.util.*;
public class _1932 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] dp = new int[n+1][n+1];
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1;j<=i;j++)
			{
				dp[i][j] = sc.nextInt();
			}
		} 
		for (int i = 1; i<=n; i++)
		{
			for (int j = 1; j<=n;j++) {
				 if (j == 1)
	                    dp[i][j] = dp[i - 1][j] + dp[i][j];	//���� �� + ������ ���Ѱ� ���� (����)
	                else if (i== j)
	                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j];	//������ + ������ ���Ѱ� ���� (������)  
	                else
	                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + dp[i][j]; //�� �� �߿� ���� �� ū�� (���) 
	 
	                if (sum < dp[i][j])
	                    sum = dp[i][j];

			}
		}
		System.out.println(sum);
		
	}

}
