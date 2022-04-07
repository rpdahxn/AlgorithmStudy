import java.util.*;
import java.io.*;

public class BOJ9251 {
	static int[][] cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine(), b = br.readLine();
		int[][] cnt = new int[b.length()+1][a.length()+1];
		
		for(int i=1; i<=b.length(); i++) 
			for(int j=1; j<=a.length(); j++) {
				if(a.charAt(j-1) == b.charAt(i-1))
					cnt[i][j] = cnt[i-1][j-1] + 1;
				else cnt[i][j] = Math.max(cnt[i-1][j], cnt[i][j-1]);
			}
		
		System.out.println(cnt[b.length()][a.length()]);
		br.close();
	}
}
