import java.util.*;
public class _14501 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] T = new int[n+10];
		int [] P = new int [n+10];
		int [] dp = new int[n+10];
		int max = 0;
		for (int i = 1; i<=n;i++)
		{
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		//int max = P[1];
		for (int i = 1; i<=n+1;i++)
		{
			dp[i] = Math.max(dp[i], max);
			dp[T[i]+i] = Math.max(dp[T[i]+i], P[i]+dp[i]);	//���� ) 1�� -> ��� 3�� �ɸ� -> 4��° �Ǵ� ������ 1��° ������ ������ 
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
