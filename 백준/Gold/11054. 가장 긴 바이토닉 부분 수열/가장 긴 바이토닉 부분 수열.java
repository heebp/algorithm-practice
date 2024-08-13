import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dpl = new int[N];
        int[] dpr = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j])
                    dpl[i] = Math.max(dpl[i], dpl[j] + 1);
            }
        }
        for(int i = N - 1; i >= 0; i--){
            for (int j = N - 1; j >= i; j--) {
                if(arr[i] > arr[j])
                    dpr[i] = Math.max(dpr[i] , dpr[j] + 1);
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dpr[i] + dpl[i] + 1);
        }
        System.out.println(max);
        br.close();
    }
}
