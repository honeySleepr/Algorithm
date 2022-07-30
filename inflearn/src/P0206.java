import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>뒤집은 소수</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/29</h3>
 */
public class P0206 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        /* 2~5번 테스트 케이스만 입력값의 맨 뒤에 공백이 추가되어 있어 Integer.parseInt() 할 때 에러가 떴다. */
        /* 해결을 위해 trim()을 붙여 공백을 없애줬다 */
        String reversedString = new StringBuilder(br.readLine().trim()).reverse().toString();
        String[] split = reversedString.split("\\s");
        int[] numArr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(split[i]);
            if (max < num) {
                max = num;
            }
            numArr[i] = num;
        }

        int[] primeArr = new int[max + 1];
        /* 0 : 소수, 1 : 소수 아님*/
        primeArr[0] = 1;
        primeArr[1] = 1;
        for (int i = 2; i * i <= max; i++) {
            if (primeArr[i] == 0) {
                for (int k = i * i; k <= max; k += i) {
                    primeArr[k] = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        /* 뒤집어지기 전 순서대로 출력하기 위함 */
        for (int i = numArr.length - 1; i >= 0; i--) {
            int num = numArr[i];
            if (primeArr[num] == 0) {
                sb.append(num).append(" ");
            }
        }
        System.out.println(sb);

    }
}
/*
9
32 55 62 20 250 370 200 30 100

*/
