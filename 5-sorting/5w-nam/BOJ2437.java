import java.io.*;
import java.util.*;

public class BOJ2437 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), sum = 0;
		int[] ar = new int[n];
		
		StringTokenizer s = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) ar[i] = Integer.parseInt(s.nextToken());
		Arrays.sort(ar);
		
		for(int i=0; i<n; i++) {
			if(sum+1 < ar[i]) break;
			sum += ar[i];
		}
		
		System.out.print(sum+1);
	}
}
