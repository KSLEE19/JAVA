import java.io.*;
import java.util.*;

public class BOJ_1987 {
    static int[] bfs_x = {1, -1, 0, 0};
    static int[] bfs_y = {0, 0, 1, -1};
    static char[][] alphabets;
    static boolean[][] map_check;
    static boolean[] check = new boolean[26];
    static int R,C, count = 0,result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphabets = new char[R][C];
        map_check = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                alphabets[i][j] = input.charAt(j);
            }
        }
        map_check[0][0] = true;
        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int x, int y) {
        char alphabet = alphabets[x][y];
        count++;
        if (check[alphabet - 'A']) {
            count--;
            result = Math.max(result, count);
            map_check[x][y] = false;
            return;
        }
        check[alphabet - 'A'] = true;
        if(x == R - 1 && y == C - 1){
            result = Math.max(result, count);
            map_check[x][y] = false;
            check[alphabet-'A'] = false;
            count--;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int next_x = x + bfs_x[i];
            int next_y = y + bfs_y[i];
            if (next_x < 0 || next_y < 0 || next_x >= R || next_y >= C) {
                continue;
            }
            if (map_check[next_x][next_y]) {
                continue;
            }
            map_check[next_x][next_y] = true;
            dfs(next_x, next_y);
        }
        check[alphabet - 'A'] = false;
        map_check[x][y] = false;
        count--;
    }
}
