package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Case #1: 1 + 1 = 2
public class BJ11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            int[] arr = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
            sb.append("Case #")
                .append(i + 1)
                .append(": ")
                .append(arr[0])
                .append(" + ")
                .append(arr[1])
                .append(" = ")
                .append(arr[0] + arr[1])
                .append("\n");
        }
        System.out.println(sb);
    }
}