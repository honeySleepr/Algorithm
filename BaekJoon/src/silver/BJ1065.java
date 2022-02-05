package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 한수
public class BJ1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt((br.readLine()));
        if (input < 100) {
            System.out.println(input);
            return;
        }
        int count = 99; // 예제를 봤을 때 한 자리, 두 자리 수는 전부 한수로 취급되는 듯 하다
        for (int i = 100; i < input + 1; i++) {
            if (check(i)) {
                count++;
            }
        }
        System.out.println(count);

    }

    public static boolean check(int num) {
        int digit1 = num % 10;
        num = num / 10;
        int digit2 = num % 10;
        int commonDelta = digit1 - digit2;

        while (num >= 10) {
            digit1 = num % 10;
            num = num / 10;
            digit2 = num % 10;

            if (commonDelta != digit1 - digit2) {
                return false;
            }
        }
        return true;
    }
}
