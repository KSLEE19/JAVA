package practice;

import java.io.*;
import java.util.Vector;

public class BaekJoon_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int count=Integer.parseInt(br.readLine());
        int word_checker=0;
        for(int i=0;i<count;i++){
            String word=br.readLine();
            boolean check=true;
            Vector<Character> char_arr=new Vector<>();
            char_arr.add(word.charAt(0));
            for(int j=1;j<word.length();j++){
                if(word.charAt(j)!=word.charAt(j-1)){
                    for(int k=0;k<char_arr.size();k++){
                        if(char_arr.get(k)==word.charAt(j)){
                            check=false;
                            j=word.length()-1;
                            break;
                        }
                    }
                    char_arr.add(word.charAt(j));
                }
            }
            if(check){
                word_checker++;
            }
        }
        bw.write(String.valueOf(word_checker)+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
