package algorithm;
import java.util.*;
import java.io.*;

public class BOJ1966 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine()), tmp;
		
		for(int i=0; i<k; i++) 
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			Queue<Integer> q = new LinkedList<Integer>();
			for(int j=0; j<n; j++) 
			{
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				
				if(j == m) num += n;
				q.offer(num);
			} // N, M 입력
			
			int cnt = 0; 
			while(!q.isEmpty()) 
			{
				int max = -1;
				for(int j=0; j<n; j++) 
				{
					tmp = q.peek();
					
					if(tmp>=n && (tmp-n)<max) {
						max = tmp-n;
					} else if(max < tmp) max = tmp;
				} //현재 큐에서 우선순위 max값 확인
				
				while(true) {
					tmp = q.poll();
					
					if(tmp==max || tmp-n==max) break;
					else q.offer(tmp);
				} //우선순위 max값 poll
				cnt++;
				
				if(tmp>=n) {
					System.out.println(cnt);
					return;
				}
			} 
		}
		
	}
}
