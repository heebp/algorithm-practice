import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Set<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		int Tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 1; i <= Tc; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken()) - 1;
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int s = 0;
			int e = arr.length - 1;
			System.out.println("#"+i+" "+recur(s, e, K, arr, Math.abs(arr[s]- arr[e])));
			set.clear();
		}
	
	}
	static int recur(int s, int e, int K, int[] arr, int res) {
		if(e - s <= K || set.contains(s+","+e)) {
			return res;
		}
		set.add(s+","+e);
		return Math.min(recur(s + 1, e, K, arr, Math.min(res, Math.abs(arr[s + 1] - arr[e]))), 
				recur(s , e - 1, K, arr, Math.min(res, Math.abs(arr[s] - arr[e - 1]))));
	}
}
