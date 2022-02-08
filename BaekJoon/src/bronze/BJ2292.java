package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//기본수학1 : 벌집
public class BJ2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        int startPoint = 1;
        int count = 1;

        while (target > startPoint) {
            startPoint += 6 * count; // 1, 7, 19, 37...
            count++;
        }
        System.out.println(count);
    }
}
