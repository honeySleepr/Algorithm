package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 분수 찾기
public class BJ1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        if (input == 1) {
            System.out.println("1/1");
            return;
        }

        int base = 1;
        int step = 1;
        while (input > base) {
            step++;
            base += step;
        }
        int top;
        int bottom;
        int leftover = input - (base - step);
        if (step % 2 == 0) {
            top = 1 + (leftover - 1);
            bottom = step - (leftover - 1);
        } else {
            top = step - (leftover - 1);
            bottom = 1 + (leftover - 1);
        }
        System.out.println(top + "/" + bottom);

    }
}
