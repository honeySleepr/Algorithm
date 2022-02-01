package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 랜선 자르기
public class BJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("\\s+");
        int initialNumberofLines = Integer.parseInt(arr[0]);
        int targetNumberofLines = Integer.parseInt(arr[1]);

        Integer[] lineLength = new Integer[initialNumberofLines];
        for (int i = 0; i < initialNumberofLines; i++) {
            lineLength[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lineLength,Comparator.reverseOrder());

    }
}
