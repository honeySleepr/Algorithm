package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
(A+B)%C는 ((A%C) + (B%C))%C 와 같을까?

(A×B)%C는 ((A%C) × (B%C))%C 와 같을까?

세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
*/
public class BJ10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        String[] arr = br.readLine().split("\\s+");
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = Integer.parseInt(arr[i]);
        }
        int a = arr2[0];
        int b = arr2[1];
        int c = arr2[2];
        System.out.println(((a + b) % c));
        System.out.println(((a % c) + (b % c)) % c);
        System.out.println(((a * b) % c));
        System.out.println(((a % c) * (b % c)) % c);

    }
}
