import java.util.Scanner;

public class _10844{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] arr = new long[n+1][10];
		long res = 0;
		
		for(int i=1; i<=9; i++)
			arr[1][i] = 1;
		
		for(int i=2; i<=n; i++)
			for(int j=0; j<=9; j++)
			{
				if(j == 0)
					arr[i][j] = arr[i-1][j+1];
				else if(j == 9)
					arr[i][j] = arr[i-1][j-1];
				else
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j+1];
				arr[i][j] %= 1000000000;
			}
		
		for(int i=0; i<=9; i++)
			res += arr[n][i];
		System.out.println(res % 1000000000);
	}
}