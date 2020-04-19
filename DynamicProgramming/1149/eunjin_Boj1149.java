import java.util.*;
public class _1149 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] rgb = new int[n][3];
		int [][] dp = new int [n][3];	//빨초파로 칠할때 최소 합 담아놓기

		
		for(int i = 0; i < n; i++) {
			rgb[i][0] = sc.nextInt();
			rgb[i][1] = sc.nextInt();
			rgb[i][2] = sc.nextInt();
		} 
		
		for(int i = 1; i < n; i++) {
			rgb[i][0] += Math.min(rgb[i-1][1], rgb[i-1][2]);
			rgb[i][1] += Math.min(rgb[i-1][0], rgb[i-1][2]);
			rgb[i][2] += Math.min(rgb[i-1][0], rgb[i-1][1]);
		}
		System.out.println(Math.min(rgb[n-1][0], Math.min(rgb[n-1][1], rgb[n-1][2])));
	}

}
