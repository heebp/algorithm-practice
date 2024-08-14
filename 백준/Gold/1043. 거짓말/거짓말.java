import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;
        String input = br.readLine();
        String[] s = input.split("\\s");
        Set<Integer> know = new HashSet<>();
        for (int i = 1; i < s.length; i++) {
            know.add(Integer.parseInt(s[i]));
        }
        List<List<Integer>> parties = new ArrayList<>();
        for(int i = 0; i < M; i++){
            parties.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            List<Integer> party = parties.get(i);
            for (int j = 0; j < length; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < parties.size(); i++) {
            List<Integer> party = parties.get(i);
            for (int j = 0; j < party.size() - 1; j++) {
                union(party.get(j), party.get(j + 1), parent);
            }
        }
        int answer = 0;
        for (int i = 0; i < M; i++) {
            List<Integer> party = parties.get(i);
            if (isPartyKnowsTheTruth(party, parent, know)) {
                answer++;
            }
        }
        System.out.println(answer);
        br.close();
    }
    static boolean isPartyKnowsTheTruth(List<Integer> party, int[] parent, Set<Integer> know){
        for (int ppl : party) {
            for (int k : know) {
                if(find(ppl, parent) == find(k, parent)){
                    return false;
                }
            }
        }
        return true;
    }

    static void union(int a, int b, int[] parent){
        a = find(a, parent);
        b = find(b, parent);

        if(a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }
    static int find(int x, int[] parent){
        if(x == parent[x])
            return x;
        return parent[x] = find(parent[x], parent);
    }
}
