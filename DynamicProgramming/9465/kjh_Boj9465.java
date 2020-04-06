import java.util.Scanner;

public class _9465 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		for(int i=0; i<test; i++)
		{
			int n = sc.nextInt();
			int[][] arr = new int[2][n+1];
			
			for(int j=0; j<2; j++)
				for(int k=1; k<=n; k++)
					arr[j][k] = sc.nextInt();
			
			for(int j=2; j<=n; j++)
			{
				arr[0][j] += Math.max(arr[1][j-2], arr[1][j-1]);
				arr[1][j] += Math.max(arr[0][j-2], arr[0][j-1]);
			}
			
			System.out.println(Math.max(arr[0][n], arr[1][n]));
		}
	}
}