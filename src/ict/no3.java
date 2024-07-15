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


class Result2 {

    /*
     * Complete the 'doesCircleExist' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY commands as parameter.
     */

    public static List<String> doesCircleExist(List<String> commands) {
        int x, y;   // 현재 좌표 (0, 0)
        int direction; // 북, 동, 남, 서 : 0, 1, 2, 3
        // 오른쪽으로 돌면 direction += 1
        // 왼쪽으로 돌면 direction -= 1

        List<String> answer = new ArrayList<>();
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean flag;
        for (int i = 0; i < commands.size(); i++) {
            flag = false;
            x = 0;
            y = 0;
            direction = 0;
            for (int j = 0; j < 4; j++) {
                for (char c : commands.get(i).toCharArray()) {
                    if (c == 'G') {
                        x += moves[direction][0];
                        y += moves[direction][1];
                    } else if (c == 'L') {
                        if (direction == 0) direction = 3;
                        else direction -= 1;
                    } else {
                        if (direction == 3) direction = 0;
                        else direction += 1;
                    }
                }
                if (x == 0 && y == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                answer.add("YES");
            } else answer.add("NO");
        }
        return answer;
    }

}
public class no3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int commandsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> commands = IntStream.range(0, commandsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result2.doesCircleExist(commands);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

