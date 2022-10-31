package practice;

import java.io.*;
import java.util.LinkedList;

class Book{
    int priority;
    boolean check;
    Book(int priority,boolean check){
        this.priority=priority;
        this.check= check;
    }
}
public class BaekJoon_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int count=Integer.parseInt(br.readLine());
        for(int i=0;i<count;i++){
            LinkedList<Book> book_queue=new LinkedList<>();
            String[] input_arr=br.readLine().split(" ");
            int book_count=Integer.parseInt(input_arr[0]);
            int M=Integer.parseInt(input_arr[1]);
            String[] book_pri=br.readLine().split(" ");
            for(int j=0;j<book_count;j++){
                if(M==j){
                    book_queue.offer(new Book(Integer.parseInt(book_pri[j]),true));
                }
                else {
                    book_queue.offer(new Book(Integer.parseInt(book_pri[j]), false));
                }
            }
            int c=0;
            while(true){
                Book front=book_queue.poll();
                boolean flag=true;
                for(int k=0;k<book_queue.size();k++){
                    if(front.priority<book_queue.get(k).priority){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    ++c;
                    if(front.check){
                        break;
                    }
                }
                else{
                    book_queue.offer(front);
                }
            }
            bw.write(c+"\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
