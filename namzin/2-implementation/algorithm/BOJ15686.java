package algorithm;
import java.awt.*;
import java.io.*;
import java.util.*;

public class BOJ15686 {
	static int n, m, result;
	static ArrayList<Point> hom, chk;
	static boolean[] visited;
	static int[] output;
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		hom = new ArrayList<Point>();
		chk = new ArrayList<Point>();
		result = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp==1) hom.add(new Point(i, j));
				else if(tmp==2) chk.add(new Point(i, j));
			}
		}
		
		visited = new boolean[chk.size()];
		output = new int[m];
		// output은 m개 선택한 치킨집들의 index
		
		for(int i=0; i<chk.size(); i++) {
			visited[i] = true;
			selectChk(i, 0);
			visited[i] = false;
		}
		System.out.println(result);
	}
	
	public static void selectChk(int start, int depth) {
		output[depth] = start;
		
		// m개 선택되는 치킨집, 모든 경우 확인 
		for(int i=start; i<chk.size(); i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selectChk(i, depth+1);
			visited[i] = false;
		}
		
		if(depth==m-1) {
			int sum = 0, cur = 0;
			for(int i=0; i<hom.size(); i++) {
				// 집마다 제일 가까운 치킨거리 계산
				int min = Integer.MAX_VALUE;
				for(int j=0; j<m; j++) {
					cur = dist(hom.get(i), chk.get(output[j]));
					min = Math.min(min, cur);
				}
				sum += min;
			}
			result = Math.min(result, sum);
			// sum : 해당 경우(m개의 치킨집)의 최소 치킨거리 합
		}
	}
	
	public static int dist(Point a, Point b) {
		return Math.abs(a.x-b.x) + Math.abs(a.y-b.y);
	}
}
