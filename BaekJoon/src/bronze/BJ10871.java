package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr1 = arrConversion(br.readLine().split("\\s+"));
        int[] intArr2 = arrConversion(br.readLine().split("\\s+"));

        for (int i : intArr2) {
            if (i < intArr1[1]) {
                System.out.print(i + " ");
            }
        }
    }

    private static int[] arrConversion(String[] stringArr) {
        int[] intArr = new int[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            intArr[i] = Integer.parseInt(stringArr[i]);
        }
        return intArr;
    }
}
