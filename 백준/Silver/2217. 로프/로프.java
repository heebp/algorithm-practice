import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Integer[] rope = new Integer[N];
        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope, (o1, o2) -> o2 - o1);
        int max = 0;
        int idx = 0;
        while(idx < N){
            int w = rope[idx] * (idx + 1);
            if(max < w)
                max = w;
            idx++;
        }
        System.out.println(max);
    }
}
