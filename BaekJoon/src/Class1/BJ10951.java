package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        int a;
        int b;

        while ((s = br.readLine()) != null) {
            StringTokenizer token = new StringTokenizer(s, " ");
            a = Integer.parseInt(token.nextToken());
            b = Integer.parseInt(token.nextToken());
            sb.append(a + b).append("\n");
        }
        System.out.println(sb);
    }
}