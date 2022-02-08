import java.util.*;
import java.io.*;

public class BOJ7576 {
	static int[][] box;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(s.nextToken());
		int n = Integer.parseInt(s.nextToken());
		box = new int[n][m];
		boolean flag = false;
		
		for(int i=0; i<n; i++) {
			s = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				box[i][j] = Integer.parseInt(s.nextToken());
				if(!flag && box[i][j]==0) flag = true;
			}
		}
		
		if(!flag) {
			System.out.println("0"); return; 
		}
		bfs(n, m);
	}

	public static void bfs(int n, int m) {
		int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> queue = new LinkedList<>();
		int min = 0;
		
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++) {
				if(box[i][j]==1 && !visited[i][j]) {
					int cnt = 1;
					queue.add(new int[] {i, j, cnt});
					
					while(!queue.isEmpty()) {
						int[] v = queue.poll();
						cnt = v[2]+1;
						
						for(int k=0; k<4; k++) {
							int toi = v[0]+dx[k], toj = v[1]+dy[k];
							if(toi<0 || toj<0 || toi>=n || toj>=m) continue;
							if(visited[toi][toj]) continue;
							
							queue.add(new int[] {toi, toj, cnt});
						}
						visited[v[0]][v[1]] = true;
					}
					if(cnt > min) min = cnt;
				}
			}
	}
}
