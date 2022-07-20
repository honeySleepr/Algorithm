import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 순열 구하기(채점지원안됨)
public class P0806 {

    private static int n;
    private static int m;
    private static int answer = Integer.MAX_VALUE;
    private static int[] arr;
    private static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split1 = br.readLine().split("\\s");
        n = Integer.parseInt(split1[0]);
        m = Integer.parseInt(split1[1]);
        String[] split2 = br.readLine().split("\\s");
        arr = new int[n + 1];
        check = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(split2[i]);
        }
        int[] print = new int[m + 1];
        DFS(1, print);
    }

    private static void DFS(int L, int[] print) {
        if (L > m) {
            System.out.println(print[1] + " " + print[2]);
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            //			print[L-1]로 검사할 경우 값이 비어있는 0 index도 쓰게 되는게 찜찜해서 그냥 체크 배열을 따로 만들어 쓰는 방법이 더 깔끔한 것 같다
            //			if (print[L - 1] == arr[i]) {
            //				continue;
            //			}
            if (check[i] != 0) {
                continue;
            }
            print[L] = arr[i];

            check[i] = 1;
            DFS(L + 1, print);
            check[i] = 0;
        }

    }
}
/*
3 2
3 6 9
*/
