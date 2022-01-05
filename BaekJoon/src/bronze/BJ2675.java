package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        int repetition;
        String[] arr;
        for (int i = 0; i < testCase; i++) {

            // arr[0] : 반복 횟수, arr[1] : 문자열
            arr = br.readLine().split(" ");
            repetition =  Integer.parseInt(arr[0]);

            //문자당 repetition 만큼 반복 저장
            for (int j = 0; j < arr[1].length(); j++) {
                for (int k = 0; k < repetition; k++) {
                    builder.append(arr[1].charAt(j));
                }
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }
}

