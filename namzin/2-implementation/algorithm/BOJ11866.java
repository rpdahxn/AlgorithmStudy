package algorithm;
import java.io.*;
import java.util.*;

public class BOJ11866 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<n; i++) q.offer(i+1);
		
		System.out.print("<");
		while(true) {
			for(int i=1; i<k; i++) q.offer(q.poll());
			System.out.print(q.poll());
			
			if(q.isEmpty()) break;
			System.out.print(", ");
		}
		System.out.println(">");
	}
}
