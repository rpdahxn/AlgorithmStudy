package algorithm;
import java.io.*;
import java.util.*;


public class BOJ2667 {
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) map[i][j] = str.charAt(j)-'0';
		}
		
		bfs(n);
	}
	public static void bfs(int n) {
		int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};
		boolean[][] visited = new boolean[n][n];
		
		Queue<int[]> queue = new LinkedList<>();
		List<Integer> rank = new LinkedList<>();
		
		for(int i=0; i<n; i++) 
			for(int j=0, cnt=1; j<n; j++) 
				if(map[i][j]==1 && !visited[i][j]) {
					queue.add(new int[] {i, j});
					
					while(!queue.isEmpty()) {
						int[] v = queue.poll();
						int x=v[0], y=v[1];
						
						for(int k=0; k<4; k++) {
							int toX = x+dx[k], toY = y+dy[k];
							
							if(toX<0 || toY<0 || toX>=n || toY>=n) continue;
							if(map[toX][toY]!=1) continue;
							
							queue.add(new int[] {toX, toY});
							map[toX][toY] = map[x][y]+1;
							visited[toX][toY] = true;
						}
						
						if(map[x][y] > cnt) cnt = map[x][y];
					}
					
					rank.add(cnt);
					cnt = 1;
				}
		
		Collections.sort(rank);
		System.out.println(rank.size());
		for(int i=0; i<rank.size(); i++) System.out.println(rank.get(i));
	}
}
