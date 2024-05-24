import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<int[]> edge = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            edge.add(new int[]{0, i, Integer.parseInt(br.readLine())});
        }
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                if(i == j){
                    st.nextToken();
                    continue;
                }
                edge.add(new int[] {i, j, Integer.parseInt(st.nextToken())});
            }
        }

        edge.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int[] parent = new int[N + 1];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        
        int result = 0;
        int cnt = 0;
        for(int i = 0; i < edge.size(); i++){
            int[] e = edge.get(i);
            if(isSameGroup(e[0], e[1], parent))
                continue;
            union(e[0], e[1], parent);
            result += e[2];
            cnt++;
            if(cnt == N)
                break;
        }
        System.out.println(result);
    }
    static boolean isSameGroup(int s, int e, int[] parent){
        s = find(s, parent);
        e = find(e, parent);
        if(s == e)
            return true;
        return false;
    }

    static int find(int x, int[] parent){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x], parent);
    }
    static void union(int s, int e, int[] parent){
        s = find(s, parent);
        e = find(e, parent);
        if(s < e)
            parent[e] = s;
        else
            parent[s] = e;
    }
}
