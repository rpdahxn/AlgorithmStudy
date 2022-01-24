package algorithm;
import java.io.*;
import java.util.*;

public class BOJ2108 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), sum = 0;
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);
		
		int[] cnt = new int[arr[n-1]-arr[0]+1];
		int mod = -1, mod_idx = 0, num = 1;
		
		for(int i=0; i<n; i++) cnt[arr[i]-arr[0]]++;
		
		for(int i=0; i<cnt.length; i++) {
			if(cnt[i]==mod && num==1) {
				mod_idx = i;
				num++;
			}
			if(mod < cnt[i] && mod != cnt[i]) {
				mod = cnt[i];
				mod_idx = i;
				num = 1;
			}
		}
		
		System.out.println(Math.round(sum/(n*1.0))+"\n"+arr[n/2]);
		System.out.println((mod_idx+arr[0])+"\n"+(arr[n-1]-arr[0]));
	}
}
