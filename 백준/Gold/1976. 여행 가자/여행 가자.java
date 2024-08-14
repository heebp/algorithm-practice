import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        StringTokenizer st;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                if(st.nextToken().charAt(0) == '1'){
                    union(i, j, parent);
                }
            }
        }
        
        int[] plan = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(check(plan, parent) ? "YES" : "NO");
    }
    static boolean check(int[] plan, int[] parent) {
        for (int i = 0; i < plan.length - 1; i++) {
            if(find(plan[i], parent) != find(plan[i + 1], parent))
                return false;
        }
        return true;
    }
    static void union(int a, int b, int[] parent){
        a = find(a, parent);
        b = find(b, parent);

        if(a == b)
            return;
        if(a < b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }
    static int find(int x, int[] parent){
        if(x == parent[x])
            return x;
        return parent[x] = find(parent[x], parent);
    }
}
