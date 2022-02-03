package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        String num1 = br.readLine();
        String num2 = br.readLine();
        for (int i = 2; i >= 0; i--) {
            System.out.println((num2.charAt(i) - '0') * Integer.parseInt(num1));
        }
        System.out.println(Integer.parseInt(num1) * Integer.parseInt(num2));

    }
}
/* 숫자의 특정 자릿수가 필요할 땐 charAt 말고
%10, %100 등 나머지.를 활용하는게 더 깔끔한 것 같다.*/