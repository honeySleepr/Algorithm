package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>최대공약수와 최소공배수</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/15</h3>
 * <br><h2>comment : 유클리드 호제법</h2>
 */
public class BJ2609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        final int A = Integer.parseInt(split[0]);
        final int B = Integer.parseInt(split[1]);
        int a = A;
        int b = B;
        int remainder = 0;

        while (b != 0) {
            remainder = a % b;
            a = b;
            b = remainder;
        }
        System.out.println(a);
        System.out.println(A * B / a);
    }
}
