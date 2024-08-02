import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]> vPos = new ArrayList<>();
        int[][] map = new int[N][N];
        int blanks = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2)
                    vPos.add(new int[]{i, j});
                if(map[i][j] == 0)
                    blanks++;
            }
        }
        int answer = combination(M, 0, new ArrayList<>(), vPos, map, blanks);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
    static int combination(int depth, int idx, List<int[]> selected, List<int[]> vPos, int[][] map, int blanks) {
        if(selected.size() == depth){
            return bfs(selected, map, blanks);
        }
        int min = Integer.MAX_VALUE;
        for (int i = idx; i < vPos.size(); i++) {
            selected.add(vPos.get(i));
            min = Math.min(min, combination(depth, i + 1, selected, vPos, map, blanks));
            selected.remove(selected.size() - 1);
        }
        return min;
    }

    static int bfs(List<int[]> selected, int[][] map, int blanks) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        for (int[] pos : selected){
            visited[pos[0]][pos[1]] = true;
            q.addFirst(new int[]{pos[0], pos[1], 0});
        }
        while(!q.isEmpty()){
            if(blanks == 0)
                return q.getLast()[2];
            int[] cur = q.removeFirst();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(OOD(nr, nc, map) || visited[nr][nc] || map[nr][nc] == 1)
                    continue;
                visited[nr][nc] = true;
                if(map[nr][nc] == 0)
                    blanks--;
                q.addLast(new int[]{nr, nc, cur[2] + 1});
            }
        }
        return Integer.MAX_VALUE;
    }

    static boolean OOD(int r, int c, int[][] map){
        if(r < 0 || c < 0 || r >= map.length || c >= map[0].length)
            return true;
        return false;
    }
}
