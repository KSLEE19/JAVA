import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> cards = new PriorityQueue<>();
        int N, result = 0;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num;
            num = Integer.parseInt(br.readLine());
            cards.add(num);
        }
        while(N>2){
            int temp = 0;
            for (int i = 0; i < 2; i++) {
                temp += cards.peek();
                cards.poll();
            }
            result += temp;
            cards.add(temp);
            N--;
        }
        if (N < 2 ) {
            result = 0;
        }
        else {
            int temp = 0;
            for (int i = 0; i < 2; i++) {
                temp += cards.peek();
                cards.poll();
            }
            result += temp;
        }
        System.out.println(result);
    }
}

