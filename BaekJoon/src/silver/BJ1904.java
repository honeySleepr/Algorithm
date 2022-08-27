package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>01타일</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/26</h3>
 * <br><h2>comment : 피보나치 수열을 이룬다는건 빠르게 찾았다. 하지만 arr[i]의 값이 long 범위도 넘어선다는걸 몰랐고,
 * <br> % 연산의 분배법칙은 `(A+B) % x = (A % x + B % x) % x` 와 같이 적용 되는줄 몰랐다. </h2>
 */
public class BJ1904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n + 1];
        arr[1] = 1;
        if (n > 1) {
            arr[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 2] + arr[i - 1]) % 15746;
        }
        System.out.println(arr[n] % 15746);
    }
}
