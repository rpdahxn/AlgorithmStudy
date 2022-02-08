import java.util.*;
import java.io.*;

public class BOJ1541 {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
		Stack<Integer> num = new Stack<>();
		Stack<Character> sign = new Stack<>();
		
		int tmp = 0;
		
		for(int i=0; i<exp.length(); i++) {
			if(exp.charAt(i)>='0' && exp.charAt(i)<='9') {
				tmp *= 10;
				tmp += Character.getNumericValue(exp.charAt(i));
			} else if(exp.charAt(i) == '-' || exp.charAt(i) == '+') {
				num.push(tmp); tmp = 0;
				sign.push(exp.charAt(i));
			} 
		} num.push(tmp);
		
		int n = num.size();
		int[] a = new int[n];
		for(int i=n-1; i>=0; i--) a[i] = num.pop();
		
		char[] b = new char[n-1];
		for(int i=n-2; i>=0; i--) b[i] = sign.pop();
		
		int sum = a[0];
		
		for(int i=0, cnt=0; i<n-1; i++) {
			if(b[i]=='-') {
				while(i+2<n && b[i+1]=='+') {
					cnt += a[i+1];
					i++;
				} 
				if(cnt!=0) {
					sum -= cnt+a[i+1];
					cnt = 0;
				} else sum -= a[i+1];	
			} else if(b[i]=='+') sum += a[i+1];
		}
		System.out.println(sum);
 	}
}
