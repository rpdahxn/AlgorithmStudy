import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리부족 : 수정해야됨

public class BOJ1012 {
	static boolean[][] map; // bfs탐색시 확인한 위치는 false로 변경
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(s.nextToken());
			int n = Integer.parseInt(s.nextToken());
			int k = Integer.parseInt(s.nextToken());
			map = new boolean[n][m];
			
			while(k-->0) {
				s = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(s.nextToken());
				int b = Integer.parseInt(s.nextToken());
				map[b][a] = true;
			}
			bfs(n, m);
		}
	}
	
	static void bfs(int n, int m) {
		int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};
		Queue<int[]> queue = new LinkedList<>();
		
		int cnt = 0;
		
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				if(map[i][j]) {
					queue.add(new int[] {i, j});
					
					while(!queue.isEmpty()) {
						int[] v = queue.poll();
						
						for(int k=0; k<4; k++) {
							int toX = v[1]+dx[k], toY = v[0]+dy[k];
							
							if(toX<0 || toY<0 || toX>=m || toY>=n) continue;
							if(!map[toY][toX]) continue;
							
							queue.add(new int[] {toY, toX});
						}
						map[v[0]][v[1]] = false;
					}
					cnt++;
				}
		System.out.println(cnt);
	}
}
