import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        long[] sum = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        sum[0] = arr[0];
        for (int i = 1; i < N; i++)
            sum[i] = arr[i] + sum[i - 1];

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++)
            map.put(sum[i] % M, map.getOrDefault(sum[i] % M, 0) + 1);

        long res = map.getOrDefault(0L, 0);
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            long n = entry.getValue();
            if(n > 1)
                res += n * (n - 1) / 2;
        }
        System.out.println(res);
    }
}
