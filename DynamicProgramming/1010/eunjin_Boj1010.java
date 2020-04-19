import java.util.*;

public class _1010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n,m;
		int[][] dp = new int[31][31];
		for(int i = 0; i<=30;i++)
		{
			dp[i][0] = dp[i][i] = 1;
			for(int j = 1; j<=i;j++)
			{
				dp[i][j]=dp[i-1][j-1] + dp[i-1][j];	//파스칼 삼각형 모양
			}
		}
		while(true)
		{
			if(t==0)
				break;
			n = sc.nextInt();
			m = sc.nextInt();
			System.out.println(dp[m][n]);
			t--;
		}
		
		}

}
