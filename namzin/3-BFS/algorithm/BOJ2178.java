package algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
	static int[][] map;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) map[i][j] = str.charAt(j)-'0';
		}
		
		bfs();
		System.out.println(map[n-1][m-1]);
	}
	
	public static void bfs() {
		int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0});
		
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] v = queue.poll();
			int x=v[0], y=v[1];
			
			for(int i=0; i<4; i++) {
				int toX = x+dx[i], toY = y+dy[i];
				
				if(toX<0 || toY<0 || toX>=n || toY>=m) continue;
				if(visited[toX][toY] || map[toX][toY]==0) continue;
				
				queue.add(new int[] {toX, toY});
				map[toX][toY] = map[x][y]+1;
				visited[toX][toY] = true;
			}
		}
	}
}
