import java.util.*;
public class _2293 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j, n=sc.nextInt(), k=sc.nextInt();
		int coin[] = new int [n+1], dp[] = new int[k+1];
		
		for(i=1;i<=k;i++) dp[i] = 100001; dp[0] = 0;
		
		for(i=1;i<=n;i++) coin[i] = sc.nextInt();
		
		for(i=1;i<=n;i++)
			for(j=coin[i];j<=k;j++)
				dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
		
		if(dp[k]==100001) dp[k] = -1;
		System.out.println(dp[k]);
		
		sc.close();
	}
}
