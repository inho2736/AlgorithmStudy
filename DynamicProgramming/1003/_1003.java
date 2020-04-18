import java.util.Scanner;

public class _1003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		while(test > 0)
		{
			int n = sc.nextInt();
			int[] dp0 = new int[n+1];
			int[] dp1 = new int[n+1];
			
			for(int i=0; i<=n; i++)
			{
				if(i == 0)
				{
					dp0[i] = 1;
					dp1[i] = 0;
				}
				else if(i == 1)
				{
					dp0[i] = 0;
					dp1[i] = 1;
				}
				else
				{
					dp0[i] = dp0[i-1] + dp0[i-2];
					dp1[i] = dp1[i-1] + dp1[i-2];
				}
			}
			System.out.printf("%d %d\n", dp0[n], dp1[n]);
			test--;
		}
	}
}