import java.io.*;
import java.util.*;

public class BOJ_1261 {
    static int[] bfs_x = {1, -1, 0, 0};
    static int[] bfs_y = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][] check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));
        check[0][0] = true;
        while (!pq.isEmpty()) {
            Node peek = pq.poll();
            int now_x = peek.x;
            int now_y = peek.y;
            if (now_x == N - 1 && now_y == M - 1) {
                System.out.println(peek.distance);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int next_x = now_x + bfs_x[i];
                int next_y = now_y + bfs_y[i];
                if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= M) {
                    continue;
                }
                if (check[next_x][next_y]) {
                    continue;
                }
                if (map[next_x][next_y] == 0) {
                    pq.add(new Node(next_x, next_y, peek.distance));
                    check[next_x][next_y] = true;
                    continue;
                }
                pq.add(new Node(next_x, next_y, peek.distance + 1));
                check[next_x][next_y] = true;
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int distance;

        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return (this.distance > o.distance) ? 1 : -1;
        }
    }

}
