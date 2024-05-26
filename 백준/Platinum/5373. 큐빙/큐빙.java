import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static class Cube{
        Map<Character, Side> map;
        Side U;
        Side D;
        Side F;
        Side B;
        Side L;
        Side R;
        Cube(){
            // 윗 면은 흰색, 아랫 면은 노란색, 앞 면은 빨간색,
            // 뒷 면은 오렌지색, 왼쪽 면은 초록색, 오른쪽 면은 파란색이다
            char[][] w = make('w');
            char[][] y = make('y');
            char[][] r = make('r');
            char[][] o = make('o');
            char[][] g = make('g');
            char[][] b = make('b');
            U = new Side(w,g,r,b,o, new int[]{2,0,0,2},0);
            D = new Side(y,b,r,g,o, new int[]{2,2,0,0},3);
            F = new Side(r,g,y,b,w, new int[]{2,2,2,2},1);
            B = new Side(o,b,y,g,w, new int[]{0,0,0,0}, 1);
            L = new Side(g,o,y,r,w, new int[]{0,2,0,0},2);
            R = new Side(b,r,y,o,w, new int[]{2,0,2,2},2);
            map = new HashMap<>(){{
                put('U', U);
                put('D', D);
                put('F', F);
                put('B', B);
                put('L', L);
                put('R', R);
            }};
        }
        char[][] make(char c) {
            char[][] side = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j <3; j++) {
                    side[i][j] = c;
                }
            }
            return side;
        }
    }
    static class Side{
        char[][] cur;
        char[][] left;
        char[][] down;
        char[][] right;
        char[][] up;
        int[] dir;
        int type;
        Side(char[][] cur, char[][] left, char[][] down, char[][] right, char[][] up, int[] dir, int type){
            this.cur = cur;
            this.left = left;
            this.down = down;
            this.right = right;
            this.up = up;
            this.dir = dir;
            this.type = type;
        }
        void plus(){
            copyArr(cur, rotateRight(cur));
            if(type == 0){
                swapB(left, down, dir[0], dir[1]);
                swapR(right, down, dir[2],dir[1]);
                swapB(right, up, dir[2], dir[3]);
            }else if(type == 1) {
                swaprr(left, down, dir[0]);
                swaprr(right, down, dir[0]);
                swaprr(right, up, dir[0]);
            }else if(type == 3){
                swapR(left, down, dir[0], dir[1]);
                swapB(right, down, dir[2],dir[1]);
                swapR(right, up, dir[2], dir[3]);
            }else{
                swapccR(left, down, dir[0], dir[1]);
                swapccR(right, down, dir[2],dir[1]);
                swapcc(right, up, dir[2], dir[3]);
            }
        }
        void minus(){
            copyArr(cur, rotateLeft(cur));
            if(type == 0){
                swapR(left, up, dir[0], dir[3]);
                swapB(right, up, dir[2],dir[3]);
                swapR(right, down, dir[2], dir[1]);
            }else if(type == 1){
                swaprr(left, up, dir[0]);
                swaprr(right, up, dir[0]);
                swaprr(right, down, dir[0]);
            }else if(type == 3){
                swapB(left, up, dir[0], dir[3]);
                swapR(right, up, dir[2],dir[3]);
                swapB(right, down, dir[2], dir[1]);
            }else{
                swapcc(left, up, dir[0], dir[3]);
                swapcc(right, up, dir[2],dir[3]);
                swapccR(right, down, dir[2], dir[1]);
            }
        }

        private void copyArr(char[][] side, char[][] r) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    side[i][j] = r[i][j];
                }
            }
        }

        void swapB(char[][] s1, char[][] s2, int c, int r){
            char[] tmp = new char[3];
            tmp[0] = s1[0][c];
            tmp[1] = s1[1][c];
            tmp[2] = s1[2][c];
            s1[0][c] = s2[r][0];
            s1[1][c] = s2[r][1];
            s1[2][c] = s2[r][2];
            s2[r][0] = tmp[0];
            s2[r][1] = tmp[1];
            s2[r][2] = tmp[2];
        }
        void swapR(char[][] s1, char[][] s2, int c, int r){
            char[] tmp = new char[3];
            tmp[0] = s1[0][c];
            tmp[1] = s1[1][c];
            tmp[2] = s1[2][c];
            s1[0][c] = s2[r][2];
            s1[1][c] = s2[r][1];
            s1[2][c] = s2[r][0];
            s2[r][2] = tmp[0];
            s2[r][1] = tmp[1];
            s2[r][0] = tmp[2];
        }
        void swaprr(char[][] s1, char[][] s2, int r){
            char[] tmp = new char[3];
            tmp[0] = s1[r][0];
            tmp[1] = s1[r][1];
            tmp[2] = s1[r][2];
            s1[r][0] = s2[r][0];
            s1[r][1] = s2[r][1];
            s1[r][2] = s2[r][2];
            s2[r][0] = tmp[0];
            s2[r][1] = tmp[1];
            s2[r][2] = tmp[2];
        }
        void swapcc(char[][] s1, char[][] s2, int c1, int c2){
            char[] tmp = new char[3];
            tmp[0] = s1[0][c1];
            tmp[1] = s1[1][c1];
            tmp[2] = s1[2][c1];
            s1[0][c1] = s2[0][c2];
            s1[1][c1] = s2[1][c2];
            s1[2][c1] = s2[2][c2];
            s2[0][c2] = tmp[0];
            s2[1][c2] = tmp[1];
            s2[2][c2] = tmp[2];
        }
        void swapccR(char[][] s1, char[][] s2, int c1, int c2){
            char[] tmp = new char[3];
            tmp[0] = s1[0][c1];
            tmp[1] = s1[1][c1];
            tmp[2] = s1[2][c1];
            s1[0][c1] = s2[2][c2];
            s1[1][c1] = s2[1][c2];
            s1[2][c1] = s2[0][c2];
            s2[2][c2] = tmp[0];
            s2[1][c2] = tmp[1];
            s2[0][c2] = tmp[2];
        }

        char[][] rotateRight(char[][] side) {
            char[][] r = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    r[i][j] = side[3 - j - 1][i];
                }
            }
            return r;
        }
        char[][] rotateLeft(char[][] side){
            char[][] r = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    r[i][j] = side[j][3- i - 1];
                }
            }

            return r;
        }

        void print() throws IOException {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    bw.write(cur[i][j]);
                }
                bw.write("\n");
            }
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int Tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Cube cube;

        for (int i = 0; i < Tc; i++) {
            cube = new Cube();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                String s = st.nextToken();
                char side = s.charAt(0);
                char dir = s.charAt(1);
                if(dir == '+'){
                    cube.map.get(side).plus();
                }else{
                    cube.map.get(side).minus();
                }
            }
            cube.U.print();
        }
        bw.flush();
        bw.close();
    }
}
