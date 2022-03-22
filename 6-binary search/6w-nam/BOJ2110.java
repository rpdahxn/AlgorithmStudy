import java.io.*;
import java.util.*;

public class BOJ2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(s.nextToken());
		int c = Integer.parseInt(s.nextToken());
		
		int[] map = new int[n];
		ArrayList<Integer> gap = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			map[i] = Integer.parseInt(br.readLine());
			
			int tmp = map[i] - map[i-1];
			if(i!=0 && !gap.contains(tmp)) gap.add(tmp);
		}
		Arrays.sort(map);
		Collections.sort(gap);
		
		for(int i=0; i<gap.get(gap.size()-1); i++) {
			
		}
		
		
		
		/*
		for(int i=0, cnt=0; i<n; i++) {
			for(int j=i; j<c; j++) ;
			
			
			
			if(cnt==c) {
				System.out.println(c); 
				break;
			}
			cnt = 0;
		}
		*/
	}
}
