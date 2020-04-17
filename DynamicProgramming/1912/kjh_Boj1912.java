import java.util.Scanner;

public class _1912 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		int res = -100000000;
		
		for(int i=1; i<=n; i++)
			arr[i]= sc.nextInt();
		
		for(int i=1; i<=n; i++)
		{
			dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
			res = Math.max(res, dp[i]);
		}
		System.out.println(res);
	}
}