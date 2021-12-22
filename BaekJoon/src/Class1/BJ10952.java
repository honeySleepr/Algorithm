package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr;
        String temp;
        StringBuilder sb = new StringBuilder();
        while (!(temp = br.readLine()).contains("0") ) {
            arr = temp.split("\\s+");
            sb.append(Integer.parseInt(arr[0]) + Integer.parseInt((arr[1]))).append("\n");
        }
        System.out.println(sb);
    }
}
