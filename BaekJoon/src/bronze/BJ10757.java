package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*큰 수 더하기*/
/*BigInteger 안쓰고 풀기.
자리수 다를 경우 작은 배열을 0으로 채워진 큰 배열로 값 하나씩 옮기는 방법 사용*/
public class BJ10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initialIntput = br.readLine().split("\\s+");
        String[] arr1 = initialIntput[0].split("");
        String[] arr2 = initialIntput[1].split("");

        int maxLength = Math.max(arr1.length, arr2.length);
        arr1 = matchSize(arr1, maxLength);
        arr2 = matchSize(arr2, maxLength);

        int[] numArr1 = convertToInt(arr1);
        int[] numArr2 = convertToInt(arr2);

        int[] answer = new int[maxLength + 1];
        int carry = 0;
        for (int i = maxLength - 1; i > -1; i--) {
            answer[i + 1] = (numArr1[i] + numArr2[i] + carry) % 10;
            carry = (numArr1[i] + numArr2[i] + carry) / 10;
        }
        answer[0] = carry;

        if (carry == 0) {
            for (int i = 1; i < answer.length; i++) {
                System.out.print(answer[i]);
            }
        } else {
            for (int i = 0; i < answer.length; i++) {
                System.out.print(answer[i]);
            }
        }

    }

    static String[] matchSize(String[] arr, int maxLength) {
        if (arr.length != maxLength) {
            String[] tempArr = new String[maxLength];
            Arrays.fill(tempArr, "0");
            for (int i = 0; i < arr.length; i++) {
                tempArr[i + (maxLength - arr.length)] = arr[i];
            }
            return tempArr;
        } else {
            return arr;
        }
    }
    static int[] convertToInt(String[] arr) {
        int[] numArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            numArr[i] = Integer.parseInt(arr[i]);
        }
        return numArr;
    }
}
