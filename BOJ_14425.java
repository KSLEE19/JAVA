import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Alphabet root = new Alphabet();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            Alphabet now = root;
            for (int j = 0; j < input.length(); j++) {
                char temp = input.charAt(j);
                if (now.next[temp - 'a'] == null) {
                    now.next[temp-'a'] = new Alphabet();
                }
                now = now.next[temp - 'a'];
                if (j == input.length() - 1) {
                    now.is_end = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            Alphabet now = root;
            for (int j = 0; j < input.length(); j++) {
                char temp = input.charAt(j);
                if (now.next[temp - 'a'] == null) {
                    break;
                }
                now = now.next[temp - 'a'];
                if (j == input.length() - 1 && now.is_end) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static class Alphabet{
        Alphabet[] next = new Alphabet[26];
        boolean is_end;
    }
}
