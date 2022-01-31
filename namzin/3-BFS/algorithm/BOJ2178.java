package algorithm;
import java.io.*;
import java.util.*;

//bfs·Î Ç®±â
public class BOJ2178 {
	public static StringBuilder sb;
	public static boolean[][] map;
	public static boolean[][] visited;
	public static int mindep, n, m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new boolean[n+1][m+1];
		visited = new boolean[n+1][m+1];
		mindep = Integer.MAX_VALUE;
		
		for(int i=1; i<=n; i++) {
			String str = br.readLine();
			for(int j=1, cnt=0; j<=m; j++) 
				if(str.substring(cnt, ++cnt).equals("1")) map[i][j] = true;
		}
		
		dfs(1, 1, 1);
		
		sb.append(mindep);
		bw.write(sb.toString());
		br.close();
		
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int x, int y, int depth) {
		if(x==n && y==m && mindep > depth) mindep = depth;
		if(depth >= mindep) return;
		
		visited[x][y] = true;
		if(x+1<=n && map[x+1][y] && !visited[x+1][y]) dfs(x+1, y, depth+1);
		if(y+1<=m && map[x][y+1] && !visited[x][y+1]) dfs(x, y+1, depth+1);

		if(x-1>0 && map[x-1][y] && !visited[x-1][y]) dfs(x-1, y, depth+1);
		if(y-1>0 && map[x][y-1] && !visited[x][y-1]) dfs(x, y-1, depth+1);
		visited[x][y] = false;
	}
}
