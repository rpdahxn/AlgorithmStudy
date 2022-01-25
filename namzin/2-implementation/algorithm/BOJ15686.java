package algorithm;
import java.io.*;
import java.util.*;

public class BOJ15686 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][n];
		int[][] hom = new int[2*n][2], chk = new int[13][2];
		int h = 0, c = 0;
		
		for(int i=0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) { i =  hom[h][0]; j = hom[h++][1]; }
				else if(map[i][j] == 2) { i = chk[c][0]; j = chk[c++][1]; }
			}
		}
		
		int[] distance = new int[c];
		int[] tmp = 
		int[][] remain = new int[m][2]; 
		for(int i=0; i<c; i++) {
			for(int j=0; j<h; j++) 
				distance[i] += Math.abs(hom[j][0]-chk[i][0]) + Math.abs(hom[j][1]-chk[i][1]);
		}
	}
}
