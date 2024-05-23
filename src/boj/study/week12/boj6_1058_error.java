package boj.study.week12;

import java.io.*;
import java.util.ArrayList;

// 1058번 친구
public class boj6_1058_error {
    static int[] friendNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        friendNum = new int[N];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            String[] friend = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                if (friend[j].equals("Y")) {
                    graph.get(i).add(j);
                }
            }
        }


        ArrayList<Integer> nodes;
        for (int i = 0; i < N; i++) {
            nodes = new ArrayList<>();
            for (int j = 0; j < graph.get(i).size(); j++) {
                int friend = graph.get(i).get(j);
                for (int k = 0; k < graph.get(friend).size(); k++) {
                    if (graph.get(i).contains(graph.get(friend).get(k)) && !nodes.contains(graph.get(friend).get(k))) {
                        nodes.add(graph.get(friend).get(k));
                    }
                }
            }
            friendNum[i] = nodes.size();
        }

        int maxNum = -1;
        for (int i = 0; i < N; i++) {
            if (maxNum < friendNum[i]) {
                maxNum = friendNum[i];
            }
        }
        bw.write((maxNum) + "");
        bw.close();
    }
}
