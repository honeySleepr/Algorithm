package level1;

/**
 * <h1>부족한 금액 계산하기</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/11</h3>
 * <br><h2>comment : 등차수열 공식
 * <br> 1. [첫 항 : a], [마지막 항 : b] 일때 n번째 항의 값 = n*(a+b)/2</h2>
 * <br> 2. [첫 항 : a], [공차 : d] 일때 n번째 항의 값 = n*(2*a+(n-1)*d)/2</h2>
 */
public class P82612 {

    public static void main(String[] args) {
        SolutionP82612 s = new SolutionP82612();
        System.out.println(s.solution(3, 20, 4));
    }

}

class SolutionP82612 {
    public long solution(int price, int money, int count) {
        // long answer = 0;
        // long cost = 0;
        // for (int i = 1; i <= count; i++) {
        //     cost += i * price;
        // }
        //
        // answer = money - cost;
        //
        // if (answer >= 0) {
        //     return 0;
        // } else {
        //     return -answer;
        // }

        /*---------등차수열 공식 사용--------------*/

        long answer = money - price * ((long)count * (1 + count) / 2);
        return answer >= 0 ? 0 : -answer;

    }
}
