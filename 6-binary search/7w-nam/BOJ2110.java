import java.io.*;
import java.util.*;

public class BOJ2110 {
	
	static int[] map;
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(s.nextToken());
		int c = Integer.parseInt(s.nextToken());
		
		map = new int[n];
		for(int i=0; i<n; i++) 
			map[i] = Integer.parseInt(br.readLine());
		Arrays.sort(map);
		
		int left = 1;
		int right = map[n-1] - map[0];
		int result = Integer.MIN_VALUE;
		
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(Installable(mid, n) >= c) {
				result = Math.max(result, mid);
				left = mid + 1;
			} else right = mid - 1;
		}
		
		System.out.println(result);
	}
 	
 	static int Installable(int distance, int n) {
 		
 		int idx = map[0];
 		int cnt = 1; 
 		
 		for(int i=1; i<n; i++) {
 			if(map[i]-idx >= distance) {
 				idx = map[i];
 				cnt++;
 			}
 		}
 		return cnt;
 	}
}
