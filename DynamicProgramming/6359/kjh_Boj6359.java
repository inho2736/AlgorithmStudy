import java.util.Scanner;

public class _6359 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		while(test > 0)
		{
			int n = sc.nextInt();
			int[] dp = new int[n+1];
			
			for(int i=1; i<=n; i++)
				for(int j=i; j<=n; j+=i)
					dp[j] ^= 1;
			
			int res = 0;
			for(int i=1; i<=n; i++)
				if(dp[i] == 1)
					res++;
			System.out.println(res);
			test--;
		}
	}
}