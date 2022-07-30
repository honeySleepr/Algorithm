import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>가위 바위 보</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/29</h3>
 */
public class P0203 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        String[] splitA = br.readLine().split("\\s");
        String[] splitB = br.readLine().split("\\s");
        StringBuilder sb = new StringBuilder();
        /* 1 >> 3 , 2 >> 1 , 3 >> 2 */
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(splitA[i]);
            int b = Integer.parseInt(splitB[i]);
            if (a == b) {
                sb.append('D').append("\n");
                continue;
            }
            if ((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2)) {
                sb.append('A').append("\n");
            } else {
                sb.append('B').append("\n");
            }
        }
        System.out.println(sb);
    }
}
/*
5
2 3 3 1 3
1 1 2 2 3

답 :
A
B
A
B
D
*/
