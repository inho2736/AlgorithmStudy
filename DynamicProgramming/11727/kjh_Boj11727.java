import java.util.Scanner;

public class _11727 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		
		for(int i=1; i<=n; i++)
		{
			if(i == 1) arr[i] = 1;
			else if(i == 2) arr[i] = 3;
			else
				arr[i] = (arr[i-1]+arr[i-2]*2) % 10007;
		}
		System.out.println(arr[n]);
	}
}