import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sumArr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        sumArr[1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= N; i++) {
            sumArr[i] = Integer.parseInt(st.nextToken());
            sumArr[i] += sumArr[i - 1];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(sumArr[e] - sumArr[s - 1]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
