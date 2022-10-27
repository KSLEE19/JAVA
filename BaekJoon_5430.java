package practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BaekJoon_5430 {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int oepr_count=scan.nextInt();
        for(int i=0;i<oepr_count;i++){
            boolean is_error=false;
            boolean is_reverse=false;
            String oper=scan.next();
            int size_of_array=scan.nextInt();
            String num_array=scan.next();
            Deque<String> num_arr=new ArrayDeque<>();
            String delete_brace=num_array.substring(1,num_array.length()-1);
            String[] number_array=delete_brace.split(",");

            for(int j=0;j<number_array.length;j++) {
                if(delete_brace.length()!=0) {
                    num_arr.addLast(number_array[j]);
                }
            }
            for(int j=0; j<oper.length();j++) {
                if(oper.charAt(j)=='R'){
                    is_reverse= !is_reverse;
                }
                else if(oper.charAt(j)=='D'){
                    if(num_arr.peek()==null||num_arr.peek()==""){
                        is_error=true;
                        break;
                    }
                    if(is_reverse==false){
                        num_arr.pollFirst();
                    }
                    else{
                        num_arr.pollLast();
                    }
                }
            }
            if(is_error){
                System.out.println("error");
            }
            else{
                System.out.print("[");
                int n_arr_size=num_arr.size();
                if(n_arr_size==0){
                    System.out.println("]");
                    continue;
                }
                if(is_reverse==false){
                    for(int j=0;j<n_arr_size-1;j++){
                        System.out.print(num_arr.pollFirst()+",");
                    }
                }
                else{
                    for(int j=0;j<n_arr_size-1;j++){
                        System.out.print(num_arr.pollLast()+",");
                    }
                }
                System.out.print(num_arr.pollFirst()+"]\n");
            }
        }
        scan.close();
    }
}
