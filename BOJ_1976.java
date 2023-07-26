import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976 {

    static int[][] map;
    static int[] union_find;
    static int[] route;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        union_find = new int[N + 1];
        route = new int[M];
        for (int i = 1; i <= N; i++) {
            union_find[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) {
                    union(Math.max(i,j),Math.min(i,j));
                }
            }
        }
        int check = find(route[0]);
        boolean flag = true;
        for (int i = 1; i < M; i++) {
            if (check != find(route[i])) {
                flag = false;
                System.out.println("NO");
                break;
            }
        }
        if(flag) System.out.println("YES");
    }

    static int find(int num) {
        if (union_find[num] == num) {
            return num;
        } else {
            union_find[num] = find(union_find[num]);
            return union_find[num];
        }
    }

    static void union(int a, int b) {
        int temp_a = find(a);
        int temp_b = find(b);
        if (temp_a != temp_b) {
            union_find[temp_b] = temp_a;
        }
    }
}
