import java.util.Scanner;

public class _1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		
		for(int i=2; i<= n; i++)
		{
			if(i <= 3)
				arr[i] = 1;
			else
			{
				arr[i] = arr[i-1];
				if(i%2 == 0)
					arr[i] = Math.min(arr[i/2], arr[i])+1;
				if(i%3 == 0)
					arr[i] = Math.min(arr[i/3], arr[i])+1;
			}
		}
		System.out.println(arr[n]);
	}
}