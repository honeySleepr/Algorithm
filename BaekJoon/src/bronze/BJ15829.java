package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

/**
 * <h1>Hashing</h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/06</h2>
 * <br><h2>comment : N 이 50까지 가는 경우에는 long 범위를 넘지 않기 위해 pow에 대해서도 % MOD를 매번 해줘야한다는걸 배웠다
 * <br> 모듈러 연산(나머지 구하는 연산 %)은 덧셈, 뺄셈, 곱셈에 대해서 분배법칙이 성립한다
 * <br> ex: (A*B)%C = ((A%C)*(B%C))%C</h2>
 */
public class BJ15829 {
    private static final int MOD = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();

        long sum = 0;
        long pow = 1;
        for (int i = 0; i < N; i++) {
            sum += ((chars[i] - 'a' + 1) * (pow % MOD));
            pow = (pow % MOD) * 31;
        }

        System.out.println(sum % MOD);
    }

    static class TestBJ15829 {
        @Test
        void test1() {
            int sum = 0;
            long pow = 1;
            for (int i = 0; i < 50; i++) {
                System.out.println(pow % MOD);
                pow = ((pow % MOD) * 32);
            }

            System.out.println(Integer.MAX_VALUE);
            System.out.println(MOD);
        }
    }
}
