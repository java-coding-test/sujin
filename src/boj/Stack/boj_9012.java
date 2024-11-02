package boj.Stack;

import java.io.*;
import java.util.*;

public class boj_9012 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine().trim());
        Stack<Integer> stack;
        String str;
        for(int i = 1; i <= N; i++){
            stack = new Stack<>();
            str = br.readLine().trim();
            int j;
            for (j = 0; j < str.length(); j++){
                if (str.charAt(j) == '('){
                    stack.push(j);
                } else {
                    if (stack.isEmpty()){
                        break;
                    } else stack.pop();
                }
            }
            if (stack.isEmpty() && j == str.length()){
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.close();
    }
}
