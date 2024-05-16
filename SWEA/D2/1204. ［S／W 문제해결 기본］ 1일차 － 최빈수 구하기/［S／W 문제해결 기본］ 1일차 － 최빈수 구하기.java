import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for(int i = 0; i <TC; i++) {
			String t = br.readLine();
			int[] arr = new int[101];
			String s = br.readLine();
			String[] nums = s.split("\\s");
			for(int j = 0; j < nums.length; j++) {
				arr[Integer.parseInt(nums[j])]++;
			}
			int max = 0;
			int maxIdx = -1;
			for(int j = 100; j >= 0; j--) {
				if(arr[j] > max) {
					max = arr[j];
					maxIdx = j;
				}
			}
			System.out.println("#"+t+" "+maxIdx);
		}
	}

}
