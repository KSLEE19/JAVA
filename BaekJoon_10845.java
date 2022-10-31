package practice;  //BufferedWriter.flush()는 마지막에 한번만 해서 버퍼를 출력하고 비워주기만 하면 됨

import java.io.*;
import java.util.Vector;

class Queue {
    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    Vector<Integer> my_queue=new Vector<>();
    int size=0;
    void push(int x){
        my_queue.add(x);
        size++;
    }
    void pop() throws IOException {
        if(size==0){
            bw.write(String.valueOf(-1));
        }
        else{
            bw.write(String.valueOf(my_queue.firstElement()));
            my_queue.remove(0);
            size--;
        }
        bw.write("\n");
        bw.flush();
    }
    void size() throws IOException{
        bw.write(String.valueOf(size)+"\n");
        bw.flush();
    }
    void empty() throws IOException{
        if(size==0){
            bw.write(String.valueOf(1));
        }
        else{
            bw.write(String.valueOf(0));
        }
        bw.write("\n");
        bw.flush();
    }
    void front() throws IOException{
        if(size==0){
            bw.write(String.valueOf(-1));
        }
        else{
            bw.write(String.valueOf(my_queue.firstElement()));
        }
        bw.write("\n");
        bw.flush();
    }
    void back() throws IOException{
        if(size==0){
            bw.write(String.valueOf(-1));
        }
        else{
            bw.write(String.valueOf(my_queue.lastElement()));
        }
        bw.write("\n");
        bw.flush();
    }
}
public class BaekJoon_10845 {
    public static void main(String[] args) throws IOException {
        Queue my_queue=new Queue();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s_in=br.readLine();
        int count=Integer.parseInt(s_in);
        for(int i=0;i<count;i++){
            String input=br.readLine();
            String[] s_arr= input.split(" ");
            String oper=s_arr[0];
            if(oper.equals("push")){
                int x= Integer.parseInt(s_arr[1]);
                my_queue.push(x);
            }
            else if(oper.equals("pop")){
                my_queue.pop();
            }
            else if(oper.equals("empty")){
                my_queue.empty();
            }
            else if(oper.equals("size")){
                my_queue.size();
            }
            else if(oper.equals("front")){
                my_queue.front();
            }
            else if(oper.equals("back")){
                my_queue.back();
            }
        }
    }
}
