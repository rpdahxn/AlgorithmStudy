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
		// output�� m�� ������ ġŲ������ index
		
		for(int i=0; i<chk.size(); i++) {
			visited[i] = true;
			selectChk(i, 0);
			visited[i] = false;
		}
		System.out.println(result);
	}
	
	public static void selectChk(int start, int depth) {
		output[depth] = start;
		
		// m�� ���õǴ� ġŲ��, ��� ��� Ȯ�� 
		for(int i=start; i<chk.size(); i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selectChk(i, depth+1);
			visited[i] = false;
		}
		
		if(depth==m-1) {
			int sum = 0, cur = 0;
			for(int i=0; i<hom.size(); i++) {
				// ������ ���� ����� ġŲ�Ÿ� ���
				int min = Integer.MAX_VALUE;
				for(int j=0; j<m; j++) {
					cur = dist(hom.get(i), chk.get(output[j]));
					min = Math.min(min, cur);
				}
				sum += min;
			}
			result = Math.min(result, sum);
			// sum : �ش� ���(m���� ġŲ��)�� �ּ� ġŲ�Ÿ� ��
		}
	}
	
	public static int dist(Point a, Point b) {
		return Math.abs(a.x-b.x) + Math.abs(a.y-b.y);
	}
}
