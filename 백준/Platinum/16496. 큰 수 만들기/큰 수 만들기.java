import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr, ((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));
        StringBuilder sb = new StringBuilder();
        for (String s : arr)
            sb.append(s);
        String res = sb.charAt(0) == '0' ? "0" : sb.toString();
        System.out.println(res);
    }
}
