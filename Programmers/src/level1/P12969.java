package level1;

import java.util.Scanner;

/**
 * <h1>직사각형 별찍기</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/08</h3>
 * <br><h2>comment :</h2>
 */
public class P12969 {

    public static void main(String[] args) {
        SolutionP12969 s = new SolutionP12969();
    }

}

class SolutionP12969 {
    public void solution(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < b; k++) {
            for (int i = 0; i < a; i++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
