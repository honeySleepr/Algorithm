package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>이항 계수1 </h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐</h2>
 * <h2>날짜 : 2022/09/02</h2>
 * <br><h2>comment : (n / k) = n!/k!(n-k)! </h2>
 */
public class BJ11050 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        int answer = factorial(n) / (factorial(k) * factorial(n - k));
        System.out.println(answer);
    }

    private static int factorial(int k) {
        int factorial = 1;
        for (int i = k; i > 0; i--) {
            factorial *= i;
        }
        return factorial;
    }

}
