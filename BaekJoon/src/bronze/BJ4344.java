package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] tempArr = br.readLine().split("\\s+");
            int[] arr = new int[tempArr.length - 1];
            double studentCount = Integer.parseInt(tempArr[0]);
            int sum = 0;
            double avg;
            double overAverageCount = 0;

            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(tempArr[j + 1]);
                sum += arr[j];
            }

            avg = sum / studentCount;

            //1
            // overAverageCount = (int)Arrays.stream(arr)
            //     .filter(n -> n > avg)
            //     .count();

            //2 : 조금 더 빠름
            for (int score : arr) {
                if (score > avg) {
                    overAverageCount++;
                }
            }

            String answer = String.format("%.3f%%", overAverageCount / studentCount * 100);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
