import java.io.*;
import java.util.*;

public class BOJ1026 {
    public static void main(String[] args) throws IOException 
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine()), tmp;
    	
    	int[] a = new int[n], b = new int[n];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) b[i] = Integer.parseInt(st.nextToken());
    	
    	Arrays.sort(a);
    	int cur = 0;
    	
    	while(cur!=n) 
    	{	
    		int max = 0;
    		while(max<n && b[max]>100) max++;
    		if(max==n) break;
    		
    		for(int i=max; i<n; i++)  
    			if((b[i]<101) && (b[i]>b[max])) max = i;
    		
    		tmp = a[cur];
    		for(int i=cur, j=i+1; i<max; i++, j++) {
    			while(i<max && a[i]>100) i++;
    			if(i==max) break;
    			
    			while(j<=max && a[j]>100) j++;
    			if(j>max) break;
    			a[i] = a[j];
    		}
    		a[max] = tmp+101;
    		b[max] += 101;
    		
    		while(cur<n && a[cur]>100) cur++;
    		
    	} cur=0;
    	
    	for(int i=0; i<n; i++) {
    		a[i] -= 101;
    		b[i] -= 101;
    		cur += a[i]*b[i];
    	}
    	System.out.println(cur);
    }
}