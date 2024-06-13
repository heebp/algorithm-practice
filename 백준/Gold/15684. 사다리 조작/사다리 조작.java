import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] ladder = new int[H][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a - 1][b - 1] = 1;
        }
        List<int[]> pos = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N - 1; j++) {
                if((j != 0 && ladder[i][j - 1] == 1) || ladder[i][j] == 1 || (j + 1 < N && ladder[i][j + 1] == 1))
                    continue;
                pos.add(new int[]{i, j});
            }
        }
        simulate(ladder, pos);
    }

    private static void simulate(int[][] ladder, List<int[]> pos) {
        for (int i = 0; i <= 3; i++) {
            if (backtracking(i, 0, ladder, pos)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    private static boolean backtracking(int depth, int idx, int[][] ladder, List<int[]> pos) {
        if(depth == 0){
            if(canManipulated(ladder))
                return true;
            return false;
        }
        
        for (int i = idx; i < pos.size(); i++) {
            int[] coord = pos.get(i);
            ladder[coord[0]][coord[1]] = 1;
            if (backtracking(depth - 1, i + 1, ladder, pos))
                return true;
            ladder[coord[0]][coord[1]] = 0;
        }
        return false;
    }
    private static boolean canManipulated(int[][] ladder) {
        for (int i = 0; i < ladder[0].length; i++) {
            int idx = i;
            for (int j = 0; j < ladder.length; j++) {
                if(ladder[j][idx] == 1)
                    idx++;
                else if(idx != 0 && ladder[j][idx - 1] == 1)
                    idx--;
            }
            if(idx != i)
                return false;
        }
        return true;
    }
}
