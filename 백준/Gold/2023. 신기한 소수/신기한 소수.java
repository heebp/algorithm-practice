import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        recur(N, new StringBuilder());
        bw.flush();
        bw.close();
    }

    private static void recur(int depth, StringBuilder sb) throws IOException {
        if(depth == 0){
            bw.write(sb.toString()+"\n");
            return;
        }
        for (int i = 0; i < 10; i++) {
            sb.append(i);
            if (isPrime(Integer.parseInt(sb.toString()))) {
                recur(depth - 1, sb);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static boolean isPrime(int num) {
        if(num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
