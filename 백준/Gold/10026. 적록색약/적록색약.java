import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        System.out.println(find(false, map) +" " + find(true, map));
    }

    static int find(boolean isRGBlind, char[][] map) {
        int cnt = 0;
        boolean[][] visited = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (visited[i][j])
                    continue;
                bfs(i, j, map, visited, isRGBlind);
                cnt++;
            }
        }
        return cnt;
    }
    static void bfs(int i, int j, char[][] map, boolean[][] visited, boolean isRGBlind){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        char color = map[i][j];
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int k = 0; k < 4; k++){
                int nr = cur[0] + dr[k];
                int nc = cur[1] + dc[k];
                if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || visited[nr][nc])
                    continue;
                if(!isRGBlind && map[nr][nc] != color)
                    continue;
                if(isRGBlind){
                    if(color == 'B' && map[nr][nc] != 'B')
                        continue;
                    if(color == 'R' && map[nr][nc] == 'B' || color == 'G' && map[nr][nc] == 'B')
                        continue;
                }
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }
}
