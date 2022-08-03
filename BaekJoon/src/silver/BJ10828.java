package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>스택</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/02</h3>
 * <h2>풀이 방법 : </h2>
 * <br><h2>comment : (속도) ArrayList : 424ms, Array : 396ms </h2>
 */
public class BJ10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringBuilder sb = new StringBuilder();

        String s;
        int lastIndex = 0;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            if (s.matches("push\\s\\d+")) {
                lastIndex++;
                String[] split = s.split("\\s");
                arr[lastIndex] = Integer.parseInt(split[1]);
                continue;
            }

            switch (s) {
                case "pop":
                    if (arr[lastIndex] == 0) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(arr[lastIndex]).append("\n");
                        arr[lastIndex] = 0;
                        lastIndex--;
                    }
                    break;
                case "size":
                    sb.append(lastIndex).append("\n");
                    break;
                case "empty":
                    if (arr[lastIndex] == 0) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "top":
                    if (arr[lastIndex] == 0) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(arr[lastIndex]).append("\n");
                    }
            }
        }
        System.out.println(sb);
    }

}
