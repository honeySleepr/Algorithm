package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>분해합</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/05</h2>
 * <br><h2>comment :</h2>
 */
public class BJ2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int digits = s.length();
        int target = Integer.parseInt(s);

        int number = target - 9 * digits; // 생성자가 아무리 작아도 이 값보단 커야한다
        int temp = 0;
        int sum = 0;
        int answer = 0;
        while (number < target) {
            temp = number;
            sum = temp;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (sum == target) {
                answer = number;
                break;
            }
            number++;
        }
        System.out.println(answer);
    }

}
