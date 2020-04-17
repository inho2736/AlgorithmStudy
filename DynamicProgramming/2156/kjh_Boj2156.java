import java.util.Scanner;

public class _2156 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] wine = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i=0; i<n; i++)
			wine[i+1] = sc.nextInt();
		
		dp[1] = wine[1];
		dp[2] = wine[1]+wine[2];
		
		for(int i=3; i<=n; i++)
			dp[i] = Math.max(dp[i-1], wine[i]+Math.max(dp[i-2], wine[i-1]+dp[i-3]));
		
		System.out.println(dp[n]);		
	}
}