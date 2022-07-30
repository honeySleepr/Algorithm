import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>친구인가</h1>
 * <h3>해설 참고 : O</h3>
 * <h3>코드 참고 : O</h3>
 * <h3>날짜 : 2022/07/26</h3>
 * <br><h2>comment : union(), find() 메서드는 그냥 외워야겠다.. 이해해서 짜보려 했는데 머리가 못 따라간다 </h2>
 */
public class P0906_Union_Find {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < m; i++) {
            String[] split1 = br.readLine().split("\\s");
            int a = Integer.parseInt(split1[0]);
            int b = Integer.parseInt(split1[1]);
            union(a, b);
        }

        String[] split2 = br.readLine().split("\\s");
        int start = Integer.parseInt(split2[0]);
        int end = Integer.parseInt(split2[1]);

        if (find(start) == find(end)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void union(int a, int b) {
        if (find(a) != find(b)) {
            arr[find(a)] = find(b);
        }
    }

    private static int find(int i) {
        if (i == arr[i]) {
            return i;
        }
        arr[i] = find(arr[i]);
        return arr[i];
    }

}
