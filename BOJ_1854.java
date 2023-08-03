import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1854 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Travel>[] graph = new ArrayList[n + 1];
        PriorityQueue<Integer>[] distance_arr = new PriorityQueue[n + 1];
        Comparator<Integer> integerComparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? -1 : 1;
            }
        };
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            distance_arr[i] = new PriorityQueue<>(integerComparator);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a_city = Integer.parseInt(st.nextToken());
            int b_city = Integer.parseInt(st.nextToken());
            int c_time = Integer.parseInt(st.nextToken());
            graph[a_city].add(new Travel(b_city, c_time));
        }
        PriorityQueue<Travel> pq = new PriorityQueue<>();
        pq.add(new Travel(1, 0));
        distance_arr[1].add(0);
        while (!pq.isEmpty()) {
            Travel peek = pq.poll();
            int now = peek.city;
            for (Travel t : graph[now]) {
                if (distance_arr[t.city].size() < k) {
                    distance_arr[t.city].add(t.distance + peek.distance);
                    pq.add(new Travel(t.city, t.distance + peek.distance));
                } else if(distance_arr[t.city].peek()>t.distance+peek.distance) {
                    distance_arr[t.city].poll();
                    distance_arr[t.city].add(t.distance + peek.distance);
                    pq.add(new Travel(t.city, t.distance + peek.distance));
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (distance_arr[i].size() == k) {
                System.out.println(distance_arr[i].peek());
            } else {
                System.out.println(-1);
            }
        }

    }

    static class Travel implements Comparable<Travel> {
        public int city;
        public int distance;

        public Travel(int city, int distance) {
            this.city = city;
            this.distance = distance;
        }

        @Override
        public int compareTo(Travel o) {
            if (this.distance > o.distance) {
                return 1;
            } else return -1;
        }
    }
}
