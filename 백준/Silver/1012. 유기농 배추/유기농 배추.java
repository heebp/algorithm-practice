import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] land;
    static int m;
    static int n;
    static int cnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int l = 0; l < t; l++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            land = new boolean[m][n];
            int k = Integer.parseInt(st.nextToken());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                land[x][y] = true;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (land[i][j]) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            bw.write(cnt + "\n");
            cnt = 0;
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int i, int j) {
        land[i][j] = false;
        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if ((nr >= 0 && nc >= 0) && (nr < m && nc < n)) {
                if(land[nr][nc]){
                    dfs(nr,nc);
                }
            }
        }
    }
}
