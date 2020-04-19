import java.util.*; 
public class _11048 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [][] maze = new int[n+1][m+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1;j<=m;j++)
			{
				maze[i][j] = sc.nextInt();
			}
		} 
		
		for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                maze[i][j] += Math.max(maze[i][j-1],Math.max(maze[i-1][j], maze[i-1][j-1]));
            }
        }
		System.out.println(maze[n][m]);
	}
}
