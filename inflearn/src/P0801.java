import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1. DFS로 부분집합들을 전부 구한다<br> 2. 각 부분집함 원소들이 합을 Set에 넣는다.<br> 3. Set 크기가 부분집합의 개수와 일치하지 않으면(겹치는게
 * 있다는거니까) Yes, 아니면 No<br>
 */
// https://cote.inflearn.com/contest/10/problem/08-01
// 합이 같은 부분집합(DFS : 아마존 인터뷰)
public class P0801 {

    private static int size;
    private static int[] intArr;
    private static int[] ch;
    private static Set<Integer> sumSet = new HashSet<>();
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split("\\s");
        intArr = new int[size];
        for (int i = 0; i < size; i++) {
            intArr[i] = Integer.parseInt(split[i]);
        }
        ch = new int[size];
        DFS(0);

        if (sumSet.size() < Math.pow(2, size) - 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        System.out.println("(Math.pow(2,size)-1) = " + (Math.pow(2, size) - 1));
    }

    public static void DFS(int L) {
        int count = 0;
        int sum = 0;

        if (L == size) {
            for (int i = 0; i < L; i++) {
                if (ch[i] == 1) {
                    sum += intArr[i];
                    count++;
                }
            }
            if (count > 0) {
                list.add(sum);
                sumSet.add(sum);
            }
            return;
        }
        ch[L] = 1;
        DFS(L + 1);
        ch[L] = 0;
        DFS(L + 1);
    }
}

/*
9
3 6 13 11 7 16 34 23 12
*/
// YES (답:NO)

/*
9
3 6 1 4 7 16 34 23 12
* */
// YES (답:YES)
