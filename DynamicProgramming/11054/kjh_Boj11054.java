import java.util.Scanner;

public class _11054 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] dp_up = new int[n+1];
		int[] dp_down = new int[n+1];
		int[] dp = new int[n+1];
		int res = -1;
		
		for(int i=1; i<=n; i++)
			arr[i] = sc.nextInt();
		
		for(int i=1; i<=n; i++)
		{
			dp_up[i] = 1;
			for(int j=1; j<i; j++)
				if(arr[i] > arr[j])
					dp_up[i] = Math.max(dp_up[i], dp_up[j]+1);
		}
		for(int i=n; i>=1; i--)
		{
			dp_down[i] = 1;
			for(int j=n; j>i; j--)
				if(arr[i] > arr[j])
					dp_down[i] = Math.max(dp_down[i], dp_down[j]+1);
		}
		
		for(int i=1; i<=n; i++)
		{
			dp[i] = dp_up[i]+dp_down[i]-1;
			res = Math.max(res, dp[i]);
		}
		System.out.println(res);
	}
}