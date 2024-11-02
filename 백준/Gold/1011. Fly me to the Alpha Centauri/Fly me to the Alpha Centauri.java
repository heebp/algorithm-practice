import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            calculateOptimized(dest - src);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void calculateOptimized(int dist) throws IOException {
        long sum = 0;
        int x = 0;
        int y = 0;
        while (dist > sum) {
            if (x % 2 == 0) {
                y++;
            }
            sum += y;
            x++;
        }
        bw.write(x+"\n");
    }
}