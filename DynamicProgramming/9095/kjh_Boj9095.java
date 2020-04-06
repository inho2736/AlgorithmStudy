import java.util.Scanner;

public class _9095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++)
		{
			int num = sc.nextInt();
			int[] arr = new int[num+1];
			for(int j=1; j<=num; j++)
			{
				if(j == 1) arr[j] = 1;
				else if(j == 2) arr[j] = 2;
				else if(j == 3) arr[j] = 4;
				else
					arr[j] = arr[j-1]+arr[j-2]+arr[j-3];
			}
			System.out.println(arr[num]);
		}
	}
}