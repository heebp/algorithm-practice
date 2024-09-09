import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        int K = Integer.parseInt(br.readLine());
        double res = 0;
        for(int i = 0; i < M; i++){
            if(arr[i] < K)
                continue;
            res += recur(K, sum, arr[i]);
        }
        System.out.println(res);
    }
    static double recur(int K, int sum, int num){
        if(K == 0)
            return 1;
        return (double) num / sum * recur(K - 1, sum - 1, num - 1);
    }
}