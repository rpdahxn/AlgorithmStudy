import java.util.*;
import java.io.*;

public class BOJ1012_DFS {
	static boolean[][] map, visited;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()), cnt = 0;
		
		while(t-->0) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			m = Integer.parseInt(s.nextToken());
			n = Integer.parseInt(s.nextToken());
			int k = Integer.parseInt(s.nextToken());
			map = new boolean[n][m];
			
			while(k-->0) {
				s = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(s.nextToken());
				int y = Integer.parseInt(s.nextToken());
				map[y][x] = true;
			}
		}
		
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++) 
				if(map[i][j] && !visited[i][j]) {
					dfs(i, j);
					cnt ++;
				}
		System.out.println(cnt);
	}
	
	public static void dfs(int y, int x) {
		int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
		visited[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int tox = x+dx[i], toy = y+dy[i];
			
			if(tox<0|| toy<0|| tox>=m|| toy>=n) continue;
			if(!map[toy][tox] || visited[toy][tox]) continue;
			
			dfs(toy, tox);
		}
	}
}