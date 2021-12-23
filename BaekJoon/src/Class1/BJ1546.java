package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int subject = Integer.parseInt(br.readLine());
        int count = 0;
        int max = 0;
        double sum = 0;
        int[] arr = new int[subject];
        for (String s : br.readLine().split("\\s+")) {
            arr[count] = Integer.parseInt(s);
            max = Math.max(arr[count], max);
            count++;
        }
        for (double score : arr) {
            sum += score / max * 100;
        }
        System.out.println(sum/subject);
    }
}
