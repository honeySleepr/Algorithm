package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ10757Alternative {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initialIntput = br.readLine().split("\\s+");

        BigInteger num1 = new BigInteger(String.valueOf(initialIntput[0]));
        BigInteger num2 = new BigInteger(String.valueOf(initialIntput[1]));

        System.out.println(num1.add(num2));
    }
}