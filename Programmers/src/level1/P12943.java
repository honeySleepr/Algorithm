package level1;

/**
 * <h1>콜라츠 추측</h1>
 * <h3>도움!! : O</h3>
 * <h3>날짜 : 2022/08/05</h3>
 * <br><h2>comment : "626331" 같은 경우 연산 도중 int 범위를 넘어서서 오답이 난다 </h2>
 */
public class P12943 {

    public static void main(String[] args) {
        SolutionP12943 s = new SolutionP12943();
        System.out.println(s.solution(6));
        System.out.println(s.solution(16));
        System.out.println(s.solution(626331));
    }

}

class SolutionP12943 {
    public int solution(int num) {
        long temp = num;
        if (temp == 1) {
            return 0;
        }
        int count = 0;
        while (temp != 1 && count <= 500) {
            if (temp % 2 == 0) {
                temp /= 2;
            } else {
                temp = temp * 3 + 1;
            }
            count++;
        }

        if (count > 500) {
            return -1;
        }
        return count;
    }
}
