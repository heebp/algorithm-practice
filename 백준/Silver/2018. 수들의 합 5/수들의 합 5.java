import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int s = 0;
        int e = 1;
        int sum = s + e;
        int answer = 0;
        while(s < N){
            if(sum == N)
                answer++;
            if (sum > N) {
                s++;
                sum -= s;
            }else{
                e++;
                sum += e;
            }
        }
        System.out.println(answer);
        sc.close();
    }
}
