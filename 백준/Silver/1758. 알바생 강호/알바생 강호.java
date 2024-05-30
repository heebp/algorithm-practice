import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, (o1, o2) -> o2 - o1);
        long max = 0;
        for (int i = 0; i < N; i++) {
            int tip = arr[i] - i;
            if (tip <= 0) {
                break;
            }
            max += tip;
        }
        System.out.println(max);
    }
}
