import java.util.Scanner;

public class _2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] arr = new long[n-1][2];
		
		for(int i=1; i<=n-2; i++)
		{
			if(i == 1)
				arr[i][0] = arr[i][1] = 1;
			else
			{
				arr[i][0] = arr[i-1][0] + arr[i-1][1];
				arr[i][1] = arr[i-1][0];
			}
		}
		
		if(n < 3)
			System.out.println(1);
		else
			System.out.println(arr[n-2][0] + arr[n-2][1]);
	}
}