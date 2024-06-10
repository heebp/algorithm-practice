import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arrSum = new int[N + 1][N + 1];
        for (int i = 1; i < arrSum.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < arrSum.length; j++) {
                arrSum[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < arrSum.length; i++) {
            for (int j = 1; j < arrSum.length; j++) {
                arrSum[i][j] = arrSum[i][j] + arrSum[i][j -1] + arrSum[i-1][j] - arrSum[i - 1][j - 1];
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            bw.write(arrSum[r2][c2] - arrSum[r2][c1 - 1] - arrSum[r1 - 1][c2] + arrSum[r1 - 1][c1 - 1] +"\n");
        }
        bw.flush();
        bw.close();
    }
}
