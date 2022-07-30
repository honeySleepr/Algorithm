import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>소수(에라토스테네스의 체)</h1>
 * <h3>해설 참고 : O </h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/29</h3>
 */
public class P0205 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        arr[0] = 1;
        arr[1] = 1;
        /* 0 : 소수, 1 : 소수아님 */

        for (int i = 2; i * i <= N; i++) {
            if (arr[i] == 0) { /* 소수 인 경우*/
                for (int k = i * i; k <= N; k += i) {
                    arr[k] = 1;
                    /* i = 2 --> k = 4,6,8,10.. */
                    /* i = 3 --> k = 9,12,15.. */
                    /* i = 5 --> k = 25,30,35.. */
                    /* i = 7 --> k = 49,56,.. */
                    /* k = i*i 부터 도는 이유는 예를 들어 i=7 일 때 7*2, 7*3, 7*4..는 다 앞단계에서 이미 처리됐기 때문 */
                }
            }
        }
        int answer = 0;
        for (int i : arr) {
            if (i == 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
