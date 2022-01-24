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
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(j == m) num += 10;
				q.offer(num);
			} // N, M 입력
			
			int cnt = 0; 
			while(!q.isEmpty()) 
			{
				int max = -1;
				for(int j=0; j<n; j++) {
					tmp = q.poll();
					q.offer(tmp);
					
					if((max<10&&tmp>=10&&(tmp-10)>max) || (max>=10&&tmp<10&&(max-10)<tmp)
							|| (tmp>max && max<10 && tmp<10)) max = tmp; 
				}//현재 큐에서 우선순위 max값 확인
				
				while(true) {
					tmp = q.poll();
					
					if(tmp==max || tmp-10==max) break;
					else q.offer(tmp);
				} //우선순위 max값 poll
				cnt++;
				n--;
				
				if(tmp>9) {
					System.out.println(cnt);
					q.clear();
					break;
				}
			} 
		}
		
	}
}
