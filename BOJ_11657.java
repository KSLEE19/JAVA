import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Edge> list = new ArrayList<>();
        long[] distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list.add(new Edge(A, B, C));
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = list.get(j);
                if (distance[edge.src] != Integer.MAX_VALUE &&
                        distance[edge.dst] > distance[edge.src] + edge.time) {
                    distance[edge.dst] = distance[edge.src] + edge.time;
                }
            }
        }
        boolean flag = true;
        for (int i = 0; i < M; i++) {
            Edge edge = list.get(i);
            if(distance[edge.src] != Integer.MAX_VALUE &&
                    distance[edge.dst] > distance[edge.src] + edge.time){
                flag = false;
            }
        }
        if (!flag) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        }
    }

    static class Edge{
        public int src;
        public int dst;
        public int time;

        public Edge(int src, int dst, int time) {
            this.src = src;
            this.dst = dst;
            this.time = time;
        }
    }
}
