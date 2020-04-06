import java.util.Scanner;

public class _11057 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+1][10];
		int res = 0;
		
		for(int i=0; i<=9; i++)
			arr[1][i] = 1;
		
		for(int i=2; i<=n; i++)
			for(int j=0; j<=9; j++)
			{
				if(j == 0)
					arr[i][j] = 1;
				else
					arr[i][j] = arr[i][j-1] + arr[i-1][j];
				arr[i][j] %= 10007;
			}
		
		for(int i=0; i<=9; i++)
			res += arr[n][i];
		
		System.out.println(res%10007);
	}
}