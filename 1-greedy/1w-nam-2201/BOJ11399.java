import java.io.*;
import java.util.*;

public class BOJ11399 {
	public static void main(String[] args) throws IOException {
		/*Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		Arrays.sort(arr);
					
		int sum = 0, result = 0;
		for(int i=0; i<n; i++) {
			sum+=arr[i];
			result+=sum;
		}
		
		System.out.println(result);
		scan.close();*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int sum = 0, result = 0;
		for(int i=0; i<n; i++) {
			sum += arr[i];
			result += sum;
		}
		
		System.out.println(result);
	}
}
