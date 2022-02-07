package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split("\\s+");
        int A = Integer.parseInt(arr[0]);
        int B = Integer.parseInt(arr[1]);
        int C = Integer.parseInt(arr[2]);
        if (C - B <= 0) {
            System.out.println(-1);
            return;
        }
        int x = A / (C - B) + 1;
        if (x < 1) {
            x = -1;
        }
        System.out.println(x);

    }
}
