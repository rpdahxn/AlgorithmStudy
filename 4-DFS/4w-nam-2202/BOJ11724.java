import java.util.*;
import java.io.*;

public class BOJ11724 {
	static boolean[] visited;
	static Queue<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken()), cnt = 0;
		
		visited = new boolean[n+1];
		graph = new LinkedList[n+1];
		for(int i=1; i<=n; i++) graph[i] = new LinkedList<>();
		
		for(int i=0; i<m; i++) {
			s = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(s.nextToken());
			int b = Integer.parseInt(s.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i=1; i<=n; i++) 
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		System.out.println(cnt);
	}
	
	public static void dfs(int v) {
		visited[v] = true;
		while(!graph[v].isEmpty()) {
			int tmp = graph[v].poll();
			if(visited[tmp]) continue; 
			dfs(tmp);
		}
	}
}
