import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1753 {
    static final int Max = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        ArrayList<Node>[] graph = new ArrayList[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[V + 1];
        boolean[] check = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }
        Arrays.fill(distance,Max);
        distance[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node peek = pq.poll();
            int now = peek.value;
            if(check[now]) continue;
            check[now] = true;
            for (Node n : graph[now]) {
                int next = n.value;
                if (distance[next] > distance[now] + n.weight) {
                    distance[next] = distance[now] + n.weight;
                    pq.add(new Node(next,distance[next]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (!check[i]) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }
    static class Node implements Comparable<Node>{
        public int value;
        public int weight;

        public Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if (this.weight > o.weight) {
                return 1;
            } else return -1;
        }
    }
}
