import java.io.*;
import java.util.*;

public class BOJ4963 {
	static boolean[][] map;
	static int w, h;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			w = Integer.parseInt(s.nextToken());
			h = Integer.parseInt(s.nextToken());

			if(w==0 || h==0) break;
			map = new boolean[h][w];
			int cnt = 0;
			
			for(int i=0; i<h; i++) {
				s = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) 
					if(s.nextToken().equals("1")) map[i][j] = true;
			}
			
			for(int i=0; i<h; i++) 
				for(int j=0; j<w; j++) 
					if(map[i][j]) {
						dfs(i, j);
						cnt++;
					}
			
			System.out.println(cnt);
		}
	}
	
	public static void dfs(int y, int x) {
		int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1}; 
		int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};
		map[y][x] = false;
		
		for(int i=0; i<8; i++) {
			int tox = x+dx[i], toy = y+dy[i];
			if(tox<0 || toy<0 || tox>=w || toy>=h) continue;
			if(!map[toy][tox]) continue;
			
			dfs(toy, tox);
		}
	}
}
