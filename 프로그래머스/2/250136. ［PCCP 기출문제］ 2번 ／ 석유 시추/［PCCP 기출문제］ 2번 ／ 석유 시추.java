import java.util.*;

class Solution {
    int N, M;
    int answer = 0;

    int[] dirn = {0, 0, 1, -1};
    int[] dirm = {1, -1, 0, 0};

    /// 최적화
    int[][][] map;
    boolean[][] visit;
    int oilcnt, oil, maxoil;
    List<int[]> oilset;

    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        mapping(land);

        if (oil == 0) return 0;

        for (int col=0; col<M; col++) { // 시추관 작업
            if (answer == maxoil) return answer;
            checkDeep(col, land);
        }

        return answer;
    }

    public boolean inRange(int n, int m) {
        return (n < N) && (n >= 0) && (m < M) && (m >= 0);
    }

    public void mapping(int[][] land) {
        visit = new boolean[N][M];
        map = new int[N][M][2];
        maxoil = 0;

        oil = 0; // 오일 영역 개수
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (!visit[i][j] && land[i][j] == 1) {
                    oilset = new ArrayList<>();
                    oil++;
                    oilcnt = 0;  // 해당 영역의 오일 크기
                    
                    //추가 : 포인터
                    int[] ptr = new int[2];
                    map[i][j] = ptr;
                    mapBFS(i, j, land, ptr);
                    maxoil += oilcnt;
                    ptr[0] = oil;
                    ptr[1] = oilcnt;
                    // for (int[] o : oilset) {
                    //     map[o[0]][o[1]] = t;
                    // }
                }
            }
        }
    }

    public void mapBFS(int n, int m, int[][] land, int[] tmp) {
        Queue<int[]> q = new LinkedList<>();
        visit[n][m] = true;
        map[n][m] = tmp;
        // oilset.add(new int[]{n, m});
        q.add(new int[]{n, m});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            map[cur[0]][cur[1]] = tmp;
            oilcnt++;
            for (int i=0; i<4; i++) {
                int newn = cur[0] + dirn[i];
                int newm = cur[1] + dirm[i];

                if (inRange(newn, newm) && land[newn][newm] == 1) {
                    if (!visit[newn][newm]){
                        visit[newn][newm] = true;
                        q.add(new int[]{newn, newm});
                    }
                }
            }
        }
    }

    public void checkDeep(int col, int[][] land) {
        boolean[] keys = new boolean[oil+1];
        int sum = 0;

        for (int i=0; i<N; i++) {
            int key = map[i][col][0];

            if(keys[key] == true) continue;

            keys[key] = true;
            sum += map[i][col][1];
        }

        answer = Math.max(answer, sum);
    }
}