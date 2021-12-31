package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오. */
public class BJ10869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("\\s+");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);
    }
}

