# <문제>

https://www.acmicpc.net/problem/11051

자연수 N과 정수 K가 주어졌을 때 이항 계수 ![img](file:///C:/Users/kathe/AppData/Local/Temp/msohtmlclip1/01/clip_image002.png)를 10,007로 나눈 나머지를 구하는 프로그램을 작성하시오.  

## <입출력 예제>

* 입력 : 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ K ≤ N)
* 출력 : ![img](file:///C:/Users/kathe/AppData/Local/Temp/msohtmlclip1/01/clip_image002.png) 이항계수 (n,k)를 10,007로 나눈 나머지를 출력한다.

## <설명>

* 이항계수와 파스칼 삼각형의 성질을 정리한다.  각 항의 계수는 nCr 이며 쓸 수 있으며 양 끝이 아닌 가운데 항의 계수는 (n-1Cr-1) + (n-1Cr)이다. (nCr  + nCr+1 = n+1Cr+1)

## <문제 해결>

* 파스칼 삼각형을 만든다고 생각하고 진행했다. 
* 맨 처음 시작하는 왼쪽, 오른쪽 양 끝은 1로 채운다. i와 j가 같으면 1, i와 0이 같으면 1로 채운다. 
* trangle[i] [j] = trangle [i-1] [j-1] + trangle[i-1] [j] 로 채운다. (i = n, j = r)
* trangle 배열에 넣을 때 10,007로 나눠 채운다.

## <코드>



```java
import java.util.*;
public class _11051 {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    int K = sc.nextInt();
    
    int[][] Triangle = new int[N+1][N+1];
    
    for(int i = 0; i < Triangle.length; i++) {
        for(int j = 0; j <= i; j++) {
            if(i == j || j == 0)
                Triangle[i][j] = 1;
            else
                Triangle[i][j] = (Triangle[i-1][j-1] + Triangle[i-1][j]) % 10007;
        }
    }
    System.out.println(Triangle[N][K]);
}
}
```

