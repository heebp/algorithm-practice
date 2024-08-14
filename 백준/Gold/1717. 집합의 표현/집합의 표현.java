
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] parent;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st  = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (operation == 0) {
                union(a,b);
            }else{
                bw.write(find(a) == find(b) ? "YES\n" : "NO\n");
            }
        }
        bw.flush();
        bw.close();
    }
    public static int find(int x) {
        if (parent[x] == x ) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y){
            return;
        }
        if(x < y){
            parent[y] = x;
        } else{
            parent[x] = y;
        }
    }
}
