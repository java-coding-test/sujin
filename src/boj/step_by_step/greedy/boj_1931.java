package boj.step_by_step.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1931 {
    static int N;
    static Meeting[] meetings;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        meetings = new Meeting[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings);
        int count = 1;
        Meeting current = meetings[0];
        for (int i = 1; i < meetings.length; i++) {
            if (current.end <= meetings[i].start) {
                count++;
                current = meetings[i];
            }
        }
        bw.write(count + "");
        bw.close();
    }
}

class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.end == o.end) {
            return this.start - o.start;
        }
        return (this.end - o.end);
    }
}