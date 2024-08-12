import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 3; j < N; j++) {
                int s = i + 1;
                int e = j - 1;
                while(s < e){
                    min = Math.min(min, Math.abs(arr[i] + arr[j] - arr[s] - arr[e]));
                    if(arr[i] + arr[j] < arr[s] + arr[e])
                        e--;
                    else
                        s++;
                }
            }
        }
        System.out.println(min);
    }
}
