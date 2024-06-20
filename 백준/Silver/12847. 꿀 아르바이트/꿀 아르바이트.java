import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String[] split = input.split("\\s");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        long res = 0;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m - 1; i++) {
            res += arr[i];
        }
        int l = 0;
        int r = m - 1;
        long max = 0;
        while (r < n) {
            res += arr[r++];
            max = Math.max(max, res);
            res -= arr[l++];
        }
        System.out.println(max);
    }
}
