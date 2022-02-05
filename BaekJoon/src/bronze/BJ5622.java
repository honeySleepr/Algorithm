package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//다이얼
public class BJ5622 {
    public static void main(String[] args) throws IOException {
        String[] ref = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        //   3초 ,   4초,   5초 ...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        int totalTime = 0;
        for (String input : arr) {
            for (int i = 0; i < ref.length; i++) {
                if (ref[i].contains(input)) {
                    totalTime += i + 3;
                    break;
                }
            }
        }
        System.out.println(totalTime);
    }
}
