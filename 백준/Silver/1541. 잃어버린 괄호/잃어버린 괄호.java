import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String[] convert = input.split("\\+");
        List<Integer> num = new ArrayList<>();
        for(String s : convert){
            String[] nums = s.split("-");
            for (String sNum : nums) {
                num.add(Integer.parseInt(sNum));
            }
        }
        int delimIdx = 1;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '-')
                break;
            if(input.charAt(i) == '+')
                delimIdx++;
        }
        int min = 0;
        for (int i = 0; i < num.size(); i++) {
            if(i < delimIdx)
                min += num.get(i);
            else
                min -= num.get(i);
        }
        System.out.println(min);
    }
}
