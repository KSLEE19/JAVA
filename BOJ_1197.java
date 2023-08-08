import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197 {
    static int[] union_find;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> edgeList = new PriorityQueue<>();
        union_find = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            union_find[i] = i;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(A, B, C));
        }
        int count = 0;
        long sum = 0;
        while (count < V - 1 || !edgeList.isEmpty()) {
            Edge peek = edgeList.poll();
            int find_src = find(peek.src);
            int find_dst = find(peek.dst);
            if (find_src == find_dst) {
                continue;
            } else {
                union(peek.src, peek.dst);
                count++;
                sum += peek.weight;
            }
        }
        System.out.println(sum);
    }

    static class Edge implements Comparable<Edge>{
        public int src;
        public int dst;
        public int weight;

        public Edge(int src, int dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.weight > o.weight) {
                return 1;
            } else return -1;
        }
    }

    static int find(int number) {
        if (union_find[number] == number) {
            return number;
        } else {
            return union_find[number] = find(union_find[number]);
        }
    }

    static void union(int a, int b) {
        int find_a = find(a);
        int find_b = find(b);
        if (find_a != find_b) {
            union_find[find_b] = a;
        }
    }
}
