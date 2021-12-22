package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 숫자 뒤집기 (int 숫자 자리 바꾸기)*/
public class BJ2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("\\s+");
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0].charAt(2));
        sb.append(arr[0].charAt(1));
        sb.append(arr[0].charAt(0));
        int a = Integer.parseInt(sb.toString());

        sb.setLength(0);

        sb.append(arr[1].charAt(2));
        sb.append(arr[1].charAt(1));
        sb.append(arr[1].charAt(0));
        int b = Integer.parseInt(sb.toString());

        System.out.println(Math.max(a, b));

        /*이런 식으로도 가능
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        String[] arr1 = br1.readLine().split("\\s+");
        int num1 = Integer.parseInt(arr1[0]);
        int num2 = Integer.parseInt(arr1[1]);

        //뒤집기
        num1 = (num1 % 10 * 100) + (num1 /10 % 10 *10) + (num1 /100);
        num2 = (num2 % 10 * 100) + (num2 /10 % 10 *10) + (num2 /100);

        System.out.println(Math.max(num1, num2));
        */
    }
}
