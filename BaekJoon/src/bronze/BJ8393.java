package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ8393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());

        int answer2 = (1 + inputNum) * (inputNum / 2);
        if (inputNum % 2 != 0) {
            answer2 += (inputNum / 2) + 1;
        }
        assert answer2 != 0 ;
        System.out.println(answer2);

        /* for문 방법*/
        // int answer1 = 0;
        // for (int i = 1; i < inputNum + 1; i++) {
        //     answer1 += i;
        // }

        /* 더 간단한 방법*/
        //10 -> 10/2 = 5     1+10 2+9 3+8 4+7 5+6
        //11 -> 11/2 = 5     1+11 2+10 3+9 4+8 5+7 6
    }
}
