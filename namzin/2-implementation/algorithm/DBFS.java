package algorithm;
import java.util.*;

public class DBFS {
	public static boolean[] visited = new boolean[9];
	public static int[][] graph = {{},
			{2, 3, 8},
			{1, 7},
			{1, 4, 5},
			{3, 5},
			{3, 4},
			{7},
			{2, 6, 8},
			{1, 7}};
	
	public static void main(String[] args) {
		//dfs(1);
		bfs();
	}
	static void dfs(int v) {
		visited[v] = true;
		System.out.print(v+" ");
		
		for(int i: graph[v]) 
			if(visited[i] == false) dfs(i);
	}
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			System.out.print(v+" ");
			
			for(int i: graph[v]) 
				if(!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
		}
	}
}
