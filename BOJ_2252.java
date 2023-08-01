import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr = new ArrayList[N + 1];
        ArrayList<Integer> result = new ArrayList<>();
        int[] in_degree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[A].add(B);
            in_degree[B]++;
        }
        int count = N;
        while (count > 0) {
            int stop = -1;
            for (int i = 1; i <= N; i++) {
                if (in_degree[i] == 0) {
                    stop = i;
                    break;
                }
            }
            for (int k : arr[stop]) {
                in_degree[k]--;
            }
            in_degree[stop] = -1;
            result.add(stop);
            count--;
        }
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
