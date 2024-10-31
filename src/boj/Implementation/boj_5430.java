package boj.Implementation;

import java.io.*;
import java.util.*;

public class boj_5430 {
    static int T;
    static char[] functions;
    static boolean direction;
    static Deque<Integer> numbers = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());


        for (int t = 0; t < T; t++) {

            functions = br.readLine().toCharArray();
            int num = Integer.parseInt(br.readLine());
            numbers.clear();

            String str = br.readLine();
            if (num != 0) {
                str = str.replace("[", "");
                str = str.replace("]", "");

                for (String s : str.split(",")) {
                    numbers.add(Integer.parseInt(s));
                }
            }
//            System.out.println(numbers);


            direction = true;    // true : 정방향, false : 역방향
            boolean flag = false;
            for (char function : functions) {
                if (function == 'R') {
                    direction = !direction;
                } else {
                    if (numbers.isEmpty()) {
                        bw.write("error\n");
                        flag = true;
                        break;
                    }
                    if (direction) {
                        numbers.pollFirst();
                    } else {
                        numbers.pollLast();
                    }
                }
            }
            if (!flag) {
                bw.write("[");
                int size = numbers.size();
                if (direction) {
                    for (int i = 0; i < size; i++) {
//                    System.out.println("i:" + i);
                        bw.write(numbers.pollFirst() + "");
                        if (i != size - 1) {
                            bw.write(",");
                        }
                    }
                } else {
                    for (int i = 0; i < size; i++) {
//                    System.out.println("i:" + i);
                        bw.write(numbers.pollLast() + "");
                        if (i != size - 1) {
                            bw.write(",");
                        }
                    }
                }

                bw.write("]\n");
            }
        }
        bw.close();
    }
}
