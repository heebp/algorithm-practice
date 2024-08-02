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
        int[][] map = new int[N][M];
        List<int[]> virus = new ArrayList<>();
        List<int[]> blank = new ArrayList<>();
        int remain = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    blank.add(new int[]{i, j});
                    remain++;
                } else if (map[i][j] == 2)
                    virus.add(new int[]{i, j});
            }
        }
        List<List<int[]>> comb = new ArrayList<>();
        combination(0, blank, new ArrayList<>(), comb);
        int max = -1;
        for (List<int[]> points : comb) {
            setWall(points, 1, map);
            max = Math.max(max, bfs(virus, map, remain - 3));
            setWall(points, 0, map);
        }
        System.out.println(max);
    }

    private static int bfs(List<int[]> virus, int[][] map, int remain) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        for (int[] v : virus) {
            q.add(new int[]{v[0], v[1]});
            visited[v[0]][v[1]] = true;
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(OOD(nr, nc, map) || visited[nr][nc] || map[nr][nc] == 1)
                    continue;
                visited[nr][nc] = true;
                remain--;
                q.add(new int[]{nr, nc});
            }
        }
        return remain;
    }

    static void combination(int idx, List<int[]> blank, List<int[]> res, List<List<int[]>> comb) {
        if (res.size() == 3) {
            comb.add(new ArrayList<>(res));
            return;
        }
        for (int i = idx; i < blank.size(); i++) {
            res.add(blank.get(i).clone());
            combination(i + 1, blank, res, comb);
            res.remove(res.size() - 1);
        }
    }

    private static void setWall(List<int[]> points, int num, int[][] map) {
        for (int[] p : points) {
            map[p[0]][p[1]] = num;
        }
    }

    static boolean OOD(int r, int c, int[][] map){
        if(r < 0 || c < 0 || r >= map.length || c >= map[0].length)
            return true;
        return false;
    }
}
