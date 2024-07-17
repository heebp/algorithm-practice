import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int mid;
        int low = 1;
        int high = k;
        long cnt;
        while (low < high) {
            cnt = 0;
            mid = low + (high - low) / 2;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(N, mid / i);
            }
            if (k <= cnt) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        bw.write(low+"");
        br.close();
        bw.flush();
        bw.close();
    }
}