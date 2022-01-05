package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1076 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        public static int solve(int a, int b) {
            int result = 1;
            for (int i = 0; i < b; i++) {
                result = (result * a) % 10;
            }
            return result;
        }
    }
}
