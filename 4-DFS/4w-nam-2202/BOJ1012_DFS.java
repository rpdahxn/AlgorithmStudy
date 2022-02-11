import java.io.*;
import java.util.*;

public class BOJ1012_DFS {
	static boolean[][] map, visited;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			m = Integer.parseInt(s.nextToken());
			n = Integer.parseInt(s.nextToken());
			int k = Integer.parseInt(s.nextToken()), cnt = 0;
			
			map = new boolean[n][m];
			visited = new boolean[n][m];
			
			while(k-->0) {
				s = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(s.nextToken());
				int b = Integer.parseInt(s.nextToken());
				map[b][a] = true;
			}
			
			for(int i=0; i<n; i++)
				for(int j=0; j<m; j++) 
					if(map[i][j] && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
					
			System.out.println(cnt);
		}
	}
	
	static void dfs(int y, int x) {
		int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};
		visited[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int tox = x+dx[i], toy = y+dy[i];
			if(tox<0 || toy<0 || tox>=m || toy>=n) continue;
			if(!map[toy][tox] || visited[toy][tox]) continue;
			
			dfs(toy, tox);
		}
	}
}