package boj.study.week23;

import java.io.*;
import java.util.*;

public class boj6_1541 {
    static ArrayList<Integer> numList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int num = 0;
        boolean flag = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '+' && c != '-') {
                if (num == 0) num = c - '0';
                else num = num * 10 + (c - '0');
            } else {
                if (flag) {
                    int temp = numList.get(numList.size() - 1) + num;
//                    System.out.println(numList.get(numList.size() - 1) + " + " + num + " = " + temp);
                    numList.remove(numList.size() - 1);
                    numList.add(temp);
//                    System.out.println(numList);
                    flag = false;
                } else {
                    numList.add(num);
                }

                if (c == '+') {
                    flag = true;
                }

//                System.out.println(i + "번째 " + numList);
                num = 0;
            }

        }
        if (flag) {
            int temp = numList.get(numList.size() - 1) + num;
            numList.remove(numList.size() - 1);
            numList.add(temp);
        } else numList.add(num);

        int answer = numList.get(0);
        for (int i = 1; i < numList.size(); i++) {
            answer -= numList.get(i);
        }

//        bw.write(max(numList, exp) + "");
        bw.write(answer + "");
        bw.close();

    }

    /*
    '-' 뒤가 최대가 되도록 하는 방법 사용하려했으나 최적해가 아님
     */
    static public int max(ArrayList<Integer> nums, ArrayList<Character> exps) {
        if (exps.contains('-')) {

            int idx = exps.indexOf('-');
            if (idx == nums.size() - 1) return nums.get(nums.size() - 1);
            if (idx == nums.size() - 2) return nums.get(nums.size() - 2) - nums.get(nums.size() - 1);

            int sum = 0;
            for (int i = 0; i <= idx; i++) {
                sum += nums.get(i);
            }

            ArrayList<Integer> newNums = new ArrayList<>();
            ArrayList<Character> newExps = new ArrayList<>();
            for (int i = idx + 1; i < nums.size(); i++) {
                newNums.add(nums.get(i));
            }

            for (int i = idx + 1; i < exps.size(); i++) {
                newExps.add(exps.get(i));
            }


            return sum - min(newNums, newExps);
        }

        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        return sum;
    }

    static public int min(ArrayList<Integer> nums, ArrayList<Character> exps) {
        if (exps.contains('-')) {
            int idx = exps.indexOf('-');
            if (idx == nums.size() - 1) return nums.get(nums.size() - 1);
            if (idx == nums.size() - 2) return nums.get(nums.size() - 2) - nums.get(nums.size() - 1);

            int sum = 0;
            for (int i = 0; i <= idx; i++) {
                sum += nums.get(i);
            }

            ArrayList<Integer> newNums = new ArrayList<>();
            ArrayList<Character> newExps = new ArrayList<>();
            for (int i = idx + 1; i < nums.size(); i++) {
                newNums.add(nums.get(i));
            }

            for (int i = idx + 1; i < exps.size(); i++) {
                newExps.add(exps.get(i));
            }


            return sum - max(newNums, newExps);

        }
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        return sum;
    }
}
