import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>임시반장 정하기</h1>
 * <h3>해설 참고 : O</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/29</h3>
 * <h2>풀이 방법 : 3중 for문</h2>
 * <h2>1. A 학생이 B 학생과 1~5학년 동안 같은 반이 된 적이 있었는지 검사한다</h2>
 * <h2>2. A 학생은 고정한 채로 C,D,E... 학생들과도 똑같이 검사한다</h2>
 * <h2>3. 같은 반이 된 적이 한번이라도 나타나면 count++하고 다음 학생으로 넘어간다</h2>
 * <h2>  - ex: A와 B가 1,2학년때 모두 같은 반이었다고 해서 count++가 두 번 되도록 놔두면 안된다</h2>
 * <h2>4. count가 가장 높은 학생을 출력한다</h2>
 * <br><h2>comment : List< Map<> > 같은걸 써야되는 줄 알았는데 해결책은 3중 for문이었다.. 그래도 어렵다!</h2>
 */
public class P0211 {

    public static final int GRADE = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int S = Integer.parseInt(br.readLine());
        int[][] arr = new int[S + 1][GRADE + 1];

        for (int i = 1; i <= S; i++) {
            String[] split = br.readLine().split("\\s");
            for (int k = 1; k <= GRADE; k++) {
                arr[i][k] = Integer.parseInt(split[k - 1]);
            }
        }

        int[] countArr = new int[S + 1];
        for (int i = 1; i <= S; i++) {
            int count = 0;
            for (int j = 1; j <= S; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k <= GRADE; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        count++;
                        break;
                    }
                }
            }
            countArr[i] = count;
        }
        int max = 0;
        int answer = 1; /* 서로 반이 겹치는 학생이 한명도 없는 경우 1번 학생이 출력되어야하므로 0 대신 1로 둔다 */
        for (int i = 1; i <= S; i++) {
            if (max < countArr[i]) {
                max = countArr[i];
                answer = i;
            }
        }
        System.out.println(answer);
    }

}
