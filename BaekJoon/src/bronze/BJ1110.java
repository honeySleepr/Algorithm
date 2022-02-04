package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 더하기 사이클
public class BJ1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        String input = br.readLine();
        String num = input;
        int tempNum = 0;
        String nextNum = "";
        int cycle = 0;

        while (true) {
            if (num.length() < 2) {
                num = "0" + num;
            }
            tempNum =
                (Integer.parseInt(num) / 10)
                    + (Integer.parseInt(num) % 10);

            nextNum =
                String.valueOf(num.charAt(1)) + String.valueOf(tempNum % 10);
            cycle++;

            if (Integer.parseInt(nextNum) == Integer.parseInt(input)) {
                break;
            }
            num = nextNum;
        }
        System.out.println(cycle);
    }
}
