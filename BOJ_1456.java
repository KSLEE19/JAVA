import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int count = 0;
        boolean[] num_arr = new boolean[10000001];
        Arrays.fill(num_arr,true);
        num_arr[0] = false;
        num_arr[1] = false;
        for (int i = 2; i <= Math.sqrt(num_arr.length); i++) {
            if(!num_arr[i]) continue;
            int temp = 2*i;
            while (temp < num_arr.length) {
                num_arr[temp] = false;
                temp += i;
            }
        }
        for (int i = 2; i < num_arr.length; i++) {
            if(num_arr[i]){
               long temp = i;
                while ((double) i <= (double) B / (double) temp) {
                    if ((double) i >= (double) A / (double) temp) {
                        count++;
                    }
                    temp *= i;
                }
            }
        }
        System.out.println(count);
    }
}
