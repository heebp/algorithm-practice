
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int dp[][] = new int[100][10];
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int mod = 1_000_000_000;
        for (int i = 1; i <= 9; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j < 9 ) {
                    dp[i][j] += dp[i-1][j+1] % mod;
                }
                if (j > 0) {
                    dp[i][j] += dp[i-1][j-1] % mod;
                }
                dp[i][j] %= mod;
            }
        }
        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = (answer + dp[n - 1][i]) % mod;
        }
        bw.write( answer +"");
        bw.flush();
        bw.close();
    }
}
