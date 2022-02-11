import java.util.*;
import java.io.*;

public class BOJ2468 {
	static List<Integer> height;
	static int[][] map;
	static boolean[][] visited;
	static int n;
 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.MIN_VALUE, ex = Integer.MIN_VALUE;
		n = Integer.parseInt(br.readLine());
		
		List<Integer> counted = new ArrayList<>();
		height = new LinkedList<>();
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(s.nextToken());
				if(map[i][j] > max) {
					max = map[i][j];
					height.add(max);
				}
			}
		}
		Collections.sort(height);
		// height[0]값 기준으로 아래(flag:true)확인, 확인한 값은 counted에 저장
		// 이전 확인 영역 수 ex에 저장, 다음 확인 시 ex값과 비교(ex값이 크면 break)
		
		int cur = height.get(0);
		boolean flag = true;
		
		while(true) {
			counted.add(cur);
			int cnt = 0;
			
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					if(map[i][j]-cur>0) {
						dfs(i, j, cur);
						cnt++;
					}
			
			if(ex>cnt) break;
			else ex = cnt;
			
			if(flag) cur--;
			//else cur++;
		}
		System.out.println(ex);
	}
	
	public static void dfs(int y, int x, int cur) {
		int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
		visited[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int tox = x+dx[i], toy = y+dy[i];
			if(tox<0 || toy<0 || tox>=n || toy>=n) continue;
			if(map[toy][tox]-cur<=0 || visited[toy][tox]) continue;
			
			dfs(toy, tox, cur);
		}
	}
}
