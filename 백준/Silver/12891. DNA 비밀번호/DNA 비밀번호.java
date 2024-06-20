import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] idx = new int[]{'A', 'C', 'G', 'T'};
    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String[] split = input.split(" ");
        int[] usage = new int[100];
        int S = Integer.parseInt(split[0]);
        int P = Integer.parseInt(split[1]);
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++)
            usage[idx[i]] = -Integer.parseInt(st.nextToken());
        int l = 0;
        int r = P - 1;
        for(int i = 0; i < P - 1; i++)
            usage[s.charAt(i)]++;

        int res = 0;
        while(r < s.length()){
            usage[s.charAt(r)]++;
            if(isValid(usage))
                res++;
            usage[s.charAt(l)]--;
            l++;
            r++;
        }
        System.out.println(res);
    }

    static boolean isValid(int[] usage) {
        for (int i = 0; i < 4; i++) {
            if(usage[idx[i]] < 0)
                return false;
        }
        return true;
    }
}
