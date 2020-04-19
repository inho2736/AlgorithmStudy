import java.util.*;

public class _2293{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int [] coin = new int[n+1];
		int [] dp = new int [k+2];
		dp[0] = 1; //최초 시작점 

		for(int i = 1; i<=n; i++)
		{
			coin[i] = sc.nextInt();
		}
		dp[0] = 1;
		
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= k ; j++) {
                if(j - coin[i] >= 0) 
                	dp[j] += dp[j - coin[i]];
            }
        }
        System.out.println(dp[k]);
	}
}