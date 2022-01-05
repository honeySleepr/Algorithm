package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr;
        StringBuilder sb = new StringBuilder();
        int rep = Integer.parseInt(br.readLine());
        for (int i = 0; i < rep; i++) {
            arr = br.readLine().split("\\s+");
            sb.append(Integer.parseInt(arr[0]) + Integer.parseInt((arr[1]))).append("\n");
        }
        System.out.println(sb);
    }
}
