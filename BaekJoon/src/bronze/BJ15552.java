package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int[] arr = Arrays.stream(br.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                        .toArray();
            sb.append(arr[0] + arr[1]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    /*매번 print 하는 것 보다 StringBuilder에 쌓아뒀다가 한번에 인쇄하는게 빠르긴 한가보다*/
}
