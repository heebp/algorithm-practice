import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        int[] R = new int[2];
        int[] B = new int[2];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'R'){
                    R[0] = i;
                    R[1] = j;
                    map[i][j] = '.';
                } else if(map[i][j] == 'B'){
                    B[0] = i;
                    B[1] = j;
                    map[i][j] = '.';
                }
            }
        }
        if(dfs(0, R, B, map))
            System.out.println(1);
        else
            System.out.println(0);

        br.close();
    }

    static boolean dfs(int depth, int[] R, int[] B, char[][] map) {
        if(depth == 10)
            return false;

        for (int i = 0; i < 4; i++) {
            int[] nR = R.clone();
            int[] nB = B.clone();
            if(isRFirst(i, R, B)){
                boolean isRIn = false;
                if (move(i, nR, nB, map)) {
                    isRIn = true;
                }
                if (move(i, nB, nR, map)){
                    continue;
                }
                if(isRIn)
                    return true;
            }else{
                if(move(i, nB, nR, map)){
                    continue;
                }
                if(move(i, nR, nB, map)){
                    return true;
                }
            }
            if(dfs(depth + 1, nR, nB, map))
                return true;
        }
        return false;
    }
    static boolean isRFirst(int dir, int[] R, int[] B){
        if(dir == 0){
            return R[0] < B[0];
        }else if(dir == 1){
            return R[1] < B[1];
        }else if(dir == 2){
            return R[1] > B[1];
        }else{
            return R[0] > B[0];
        }
    }

    static boolean move(int dir, int[] target, int[] other, char[][] map){
        for (int i = 1; i < 10; i++) {
            int nr = target[0] + dr[dir] * i;
            int nc = target[1] + dc[dir] * i;
            if(map[nr][nc] == 'O'){
                target[0] = nr;
                target[1] = nc;
                return true;
            } else if(map[nr][nc] == '#' || (nr == other[0] && nc == other[1])){
                target[0] = target[0] + dr[dir] * (i - 1);
                target[1] = target[1] + dc[dir] * (i - 1);
                break;
            }
        }
        return false;
    }
}