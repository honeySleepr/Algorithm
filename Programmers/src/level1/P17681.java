package level1;

/**
 * <h1>비밀지도</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/08</h3>
 * <br><h2>comment : 비트 연산자를 사용하는게 문제 의도였다. Better 버전 풀이 참고! </h2>
 */
public class P17681 {

    public static void main(String[] args) {
        SolutionP17681 s = new SolutionP17681();
        System.out.println(s.solution(5,
            new int[] {9, 20, 28, 18, 11},
            new int[] {30, 1, 21, 17, 28}));
    }

}

class SolutionP17681 {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        System.out.println('1' | '0');
        System.out.println('1' | '1');
        System.out.println('0' | '0');
        System.out.println(String.format("%" + 7 + "s", "11101"));
        char[][] arr11 = new char[n][n];
        char[][] arr22 = new char[n][n];
        for (int i = 0; i < n; i++) {
            int a = arr1[i];
            int b = arr2[i];
            String binaryA = Integer.toBinaryString(a);
            String binaryB = Integer.toBinaryString(b);
            int diffA = n - binaryA.length();
            int diffB = n - binaryB.length();
            decriptRowOfMap(n, arr11, i, binaryA, diffA);
            decriptRowOfMap(n, arr22, i, binaryB, diffB);

        }
        StringBuilder sb = new StringBuilder();
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr11[i][j] == '#' || arr22[i][j] == '#') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        // System.out.println(Arrays.toString(answer));
        return answer;
    }

    private void decriptRowOfMap(int n, char[][] arr11, int i, String binaryA, int diff) {
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (diff > count) {
                arr11[i][j] = ' ';
                count++;
                continue;
            }
            if (binaryA.charAt(j - diff) == '1') {
                arr11[i][j] = '#';
            } else {
                arr11[i][j] = ' ';
            }
        }
    }
}
