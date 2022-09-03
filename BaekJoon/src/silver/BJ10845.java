package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>큐</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/01</h2>
 * <br><h2>comment :</h2>
 */
public class BJ10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        int head = 0;
        int tail = 0;
        int size = 0;
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("\\s");

            switch (split[0]) {
                case "push":
                    arr[tail] = Integer.parseInt(split[1]);
                    tail++;
                    size++;
                    break;
                case "pop":
                    if (arr[head] == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(arr[head]).append("\n");
                        arr[head] = null;
                        head++;
                        size--;
                    }
                    break;
                case "size":
                    sb.append(size).append("\n");
                    break;
                case "empty":
                    if (size == 0) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if (arr[head] == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(arr[head]).append("\n");
                    }
                    break;
                case "back":
                    if (tail == 0 || arr[tail - 1] == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(arr[tail - 1]).append("\n");
                    }
            }
        }
        System.out.println(sb);
    }

}
