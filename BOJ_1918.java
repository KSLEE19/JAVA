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

/*
 ** 1. ( 이면 stack에 push
 ** 2. ) 이면 (가 나올때까지 stack top을 출력
 ** 3. 사칙 연산자의 경우 자신과 같은 순위거나 높은 순위일 경우 출력
 *     -> 1순위 : *,/
 *     -> 2순위 : +,-
 */