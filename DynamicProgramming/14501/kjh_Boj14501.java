import java.util.Scanner;

public class _14501 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+1][2];
		int[] dp = new int[n+1];
		
		for(int i=1; i<=n; i++)
			for(int j=0; j<2; j++)
				arr[i][j] = sc.nextInt();
		
		for(int i=1; i<=n; i++)
		{
			if(i+arr[i][0] <= n+1)
				dp[i] = arr[i][1];
			
			int max = 0;
			for(int j=1; j<=i-1; j++)
				if(j+arr[j][0] <= i)
					max = Math.max(max, dp[j]);	
			dp[i] += max;
		}
		
		int res = 0;
		for(int i=1; i<=n; i++)
			res = Math.max(res, dp[i]);
		System.out.println(res);
	}
}