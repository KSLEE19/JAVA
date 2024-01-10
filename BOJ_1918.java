import java.io.*;
import java.util.*;


public class BOJ_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String expression = br.readLine();
        Stack<Character> operations = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                operations.push(c);
            } else if (c == ')') {
                while (operations.peek() != '(') {
                    sb.append(operations.pop());
                }
                operations.pop(); //마지막 남은 '('을 지워주기
            } else {
                if (c == '*' || c == '/') {
                    while (!operations.isEmpty() && (operations.peek() == '*' || operations.peek() == '/')) {
                        sb.append(operations.pop());
                    }
                    operations.push(c);
                } else if (c == '+' || c == '-') {
                    while (!operations.isEmpty() && operations.peek() != '(') {
                        sb.append(operations.pop());
                    }
                    operations.push(c);
                } else {
                    sb.append(c);
                }
            }
        }
        while (!operations.isEmpty()) {
            sb.append(operations.pop());
        }
        System.out.println(sb);
    }
}
