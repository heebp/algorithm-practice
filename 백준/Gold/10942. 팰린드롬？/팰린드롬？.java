import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] query = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                int k = j + i;
                if(j == k){
                    query[j][k] = true;
                    continue;
                }
                if(k - j == 1 && arr[j] == arr[k])
                    query[j][k] = true;
                if(query[j + 1][k - 1] && arr[j] == arr[k]) {
                    query[j][k] = true;
                }
            }
        }
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(query[s - 1][e - 1] ? "1\n" : "0\n");
        }
        bw.flush();
        bw.close();
    }
}
