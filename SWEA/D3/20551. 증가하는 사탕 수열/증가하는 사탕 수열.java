import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i = 1; i <= TC; i++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[3];
			for(int j = 0; j < 3; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			System.out.println("#"+i+" "+solv(arr));
		}

	}
	static int solv(int[] arr) {
		int idx = arr.length - 1;
		int sum = 0;
		while(idx > 0) {
			if(arr[idx] <= arr[idx - 1]) {
				sum += arr[idx - 1] - arr[idx] + 1;
				arr[idx - 1] = arr[idx] - 1;
			}
			if(arr[idx - 1] == 0 || arr[idx] == 0)
				return -1;
			idx--;
		}
		return sum;
	}
}
