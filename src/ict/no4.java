package ict;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {
    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {
        List<String> result = new ArrayList<>();
        findSchedulesHelper(workHours, dayHours, pattern, 0, new StringBuilder(), result);
        return result;
    }

    private static void findSchedulesHelper(int workHours, int dayHours, String pattern, int index, StringBuilder current, List<String> result) {
        if (index == pattern.length()) {

            int totalHours = 0;
            for (int i = 0; i < current.length(); i++) {
                totalHours += current.charAt(i) - '0';
            }
            if (totalHours == workHours) {
                result.add(current.toString());
            }
            return;
        }

        if (pattern.charAt(index) == '?') {
            // Try all possible values for '?'
            for (int i = 0; i <= dayHours; i++) {
                current.append(i);
                findSchedulesHelper(workHours, dayHours, pattern, index + 1, current, result);
                current.deleteCharAt(current.length() - 1); // backtrack
            }
        } else {
            // Fixed value in the pattern
            current.append(pattern.charAt(index));
            findSchedulesHelper(workHours, dayHours, pattern, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // backtrack
        }

        char c = '3';
        int hour = Integer.parseInt(c + "");
    }
}
public class no4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int workHours = Integer.parseInt(bufferedReader.readLine().trim());

        int dayHours = Integer.parseInt(bufferedReader.readLine().trim());

        String pattern = bufferedReader.readLine();

        List<String> result = Result.findSchedules(workHours, dayHours, pattern);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
