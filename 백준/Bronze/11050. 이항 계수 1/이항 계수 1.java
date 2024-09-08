import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] mul = new int[11];
        mul[0] = 1;
        for(int i = 1; i < 11; i++){
            mul[i] = mul[i - 1] * i;
        }
        System.out.println(mul[n] / mul[n - k] / mul[k]);
        br.close();
    }
}