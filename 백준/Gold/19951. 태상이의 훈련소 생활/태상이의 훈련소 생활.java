import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] arrSum = new int[arr.length];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arrSum[a - 1] += k;
            if(b != arr.length)
                arrSum[b] -= k;
        }

        for (int i = 1; i < arrSum.length; i++) {
            arrSum[i] += arrSum[i - 1];
        }
        
        for (int i = 0; i < arrSum.length; i++) {
            bw.write(arr[i] + arrSum[i] + " ");
        }
        
        bw.flush();
        bw.close();
    }
}
