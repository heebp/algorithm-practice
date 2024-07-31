import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dr = new int[]{-1,0,0,1};
    static int[] dc = new int[]{0,1,-1,0};
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];
        int[][] visited = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0, map, visited));
    }
    static int dfs(int r, int c, int[][] map, int[][] visited){
        if(r == map.length - 1 && c == map[0].length - 1){
            return 1;
        }

        if(visited[r][c] != -1)
            return visited[r][c];
        visited[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nc >= 0 && nr < map.length && nc < map[0].length){
                if(map[r][c] <= map[nr][nc])
                    continue;
                visited[r][c] += dfs(nr, nc, map, visited);
            }
        }
        return visited[r][c];
    }
}
