import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Bus>[] graph = new ArrayList[N + 1];
        int[] cost_arr = new int[N + 1];
        boolean[] check = new boolean[N + 1];
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        Arrays.fill(cost_arr, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[A].add(new Bus(B, cost));
        }
        st = new StringTokenizer(br.readLine());
        int src = Integer.parseInt(st.nextToken());
        int dst = Integer.parseInt(st.nextToken());
        cost_arr[src] = 0;
        pq.add(new Bus(src, 0));
        while (!pq.isEmpty()) {
            Bus peek = pq.poll();
            int now = peek.city;
            if(check[now]) continue;
            check[now] = true;
            for (Bus b : graph[now]) {
                int next = b.city;
                int temp = cost_arr[next];
                cost_arr[next] = Math.min(cost_arr[next], cost_arr[now] + b.cost);
                if (temp != cost_arr[next]) {
                    pq.add(new Bus(next, cost_arr[next]));
                }
            }
        }
        System.out.println(cost_arr[dst]);
    }

    static class Bus implements Comparable<Bus>{
        public int city;
        public int cost;

        public Bus(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            if (this.cost > o.cost) {
                return 1;
            } else return -1;
        }
    }
}
