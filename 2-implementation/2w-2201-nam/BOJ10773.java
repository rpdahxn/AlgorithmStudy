

import java.io.*;
import java.util.*;

public class BOJ10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine()), n, sum = 0;
		Stack<Integer> st = new Stack<>();
		
		for(int i=0; i<k; i++) {
			n = Integer.parseInt(br.readLine());
			
			if(n == 0) st.pop();
			else st.push(n);
		}
		
		while(!st.empty()) sum += st.pop();
		System.out.println(sum);
	}
}
