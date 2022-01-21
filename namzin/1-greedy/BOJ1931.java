import java.util.*;
import java.io.*;

public class BOJ1931 {
	private static int max = 0, n;
	private static int[][] arr = new int[n][2];
	
	int meeting(int cnt, int index) {
		for(int i=index+1; i<n; i++) {
			if(arr[index][1] <= arr[i][0]) cnt = meeting(++cnt, i);
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		for(int i=0; i<n; i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
		}

		int[] tmp = new int[2];
		for(int i=0; i<n; i++) 
			for(int j=i+1; j<n; j++) {
				if((arr[i][0] > arr[j][0]) || 
						((arr[i][0] == arr[j][0]) && (arr[i][1] > arr[j][1]))) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		
		for(int i=0; i<n; i++)
			System.out.printf("%d ~ %d\n", arr[i][0], arr[i][1]);
	}
}
