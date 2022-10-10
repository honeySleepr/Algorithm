package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * <h1><a href="">경로의 개수</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/08</h2>
 * <br><h2>comment :</h2>
 */
public class P1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split("\\s");
        BigInteger answer = BigInteger.valueOf(1L);
        for (String num : input) {
            answer = answer.multiply(BigInteger.valueOf(Long.parseLong(num)));
        }

        System.out.println(answer.toString());
    }

}
