import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
    static int[] union_find;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        union_find = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            union_find[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int mode = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (mode == 0) {
                union(a, b);
            } else if (mode == 1) {
                if (check(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

    }

    static void union(int a, int b) {
        int temp_a = find(a);
        int temp_b = find(b);
        if (temp_a != temp_b) {
            union_find[temp_b] = a;
        }

    }

//    static int find(int num) {
//        if (num == union_find[num]) {
//            return num;
//        } else {
//            union_find[num] = find(union_find[num]);
//            return union_find[num];
//        }
//    }

    static int find(int num) {
        if (num == union_find[num]) {
            return num;
        } else{
            return union_find[num] = find(union_find[num]);
        }
    }

    static boolean check(int a, int b) {
        if (find(a) == find(b)) {
            return true;
        } else {
            return false;
        }
    }
}
