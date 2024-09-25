import java.util.Arrays;

public class Solution {
    static final int MOD = 1_000_000_007;
    static int n, m;
    static int[] grid;
    static int lenD;
    static int[] d;
    static int size; // n*m
    static int[][] A;

    public int solution(int[][] grid2D, int[] d, int k) {
        n = grid2D.length;
        m = grid2D[0].length;
        size = n * m;
        this.d = d;
        lenD = d.length;
        grid = new int[size];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i * m + j] = grid2D[i][j];
            }
        }
        buildTransitionMatrix();
        int[][] Ak = matrixPower(A, k);
        int[] v0 = new int[size];
        Arrays.fill(v0, 1);
        int[] v = multiplyMatrixVector(Ak, v0);
        int result = 0;
        for (int val : v) {
            result = (result + val) % MOD;
        }
        return result;
    }

    private void buildTransitionMatrix() {
        A = new int[size][size];
        // For each starting position
        for (int i = 0; i < size; i++) {
            int[] dpPrev = new int[size];
            int[] dpCurr = new int[size];
            dpPrev[i] = 1;
            for (int t = 0; t < lenD; t++) {
                Arrays.fill(dpCurr, 0);
                for (int pos = 0; pos < size; pos++) {
                    if (dpPrev[pos] == 0) continue;
                    int r = pos / m;
                    int c = pos % m;
                    int[] dr = {-1, 1, 0, 0};
                    int[] dc = {0, 0, -1, 1};
                    for (int dir = 0; dir < 4; dir++) {
                        int nr = r + dr[dir];
                        int nc = c + dc[dir];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                            int posNext = nr * m + nc;
                            if (grid[posNext] - grid[pos] == d[t]) {
                                dpCurr[posNext] = (dpCurr[posNext] + dpPrev[pos]) % MOD;
                            }
                        }
                    }
                }
                // Swap dpPrev and dpCurr
                int[] temp = dpPrev;
                dpPrev = dpCurr;
                dpCurr = temp;
            }
            // After lenD steps, dpPrev contains the number of ways to reach each position from i
            for (int j = 0; j < size; j++) {
                A[i][j] = dpPrev[j];
            }
        }
    }

    private int[][] matrixPower(int[][] matrix, int power) {
        int[][] result = identityMatrix(size);
        int[][] base = matrix;
        while (power > 0) {
            if ((power & 1) == 1) {
                result = multiplyMatrices(result, base);
            }
            base = multiplyMatrices(base, base);
            power >>= 1;
        }
        return result;
    }

    private int[][] identityMatrix(int n) {
        int[][] id = new int[n][n];
        for (int i = 0; i < n; i++) {
            id[i][i] = 1;
        }
        return id;
    }

    private int[][] multiplyMatrices(int[][] a, int[][] b) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (a[i][k] == 0) continue;
                for (int j = 0; j < size; j++) {
                    result[i][j] = (int) ((result[i][j] + (long) a[i][k] * b[k][j]) % MOD);
                }
            }
        }
        return result;
    }

    private int[] multiplyMatrixVector(int[][] matrix, int[] vector) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            long sum = 0;
            for (int j = 0; j < size; j++) {
                sum = (sum + (long) matrix[i][j] * vector[j]) % MOD;
            }
            result[i] = (int) sum;
        }
        return result;
    }
}