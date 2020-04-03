package dynamicProgramming;
//import java.util.Arrays;
import java.util.Scanner;

public class Boj2193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();		
		long result;
		long[] arr = new long[num+1];
		if (num == 1) {
			result = 1;
		}
		else if(num ==2) {
			result =1;
		}
		else {
			arr[1] = 1;
			arr[2] = 1;
			for (int i=3; i<num+1; i++) {
				arr[i] = arr[i-2] + arr[i-1];
			}
			result = arr[num];
		}		
		System.out.println(result);
		sc.close();
	}
}
	
