package level1;

/**
 * <h1>약수의 개수와 덧셈</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/11</h3>
 * <br><h2>comment : 제곱수면 약수의 개수가 홀수이다! 생각해보니 간단하다
 * <br> N의 약수1은 다른 N의 약수2와 곱해서 N이 된다. 즉, 약수들은 쌍을 이룬다.(15의 약수 :(1,15),(3,5))
 * <br> 그런데 제곱수는 쌍을 이루지 않는 약수 하나를 더 가지고 있다! (16의 약수 : (1,16),(2,8),(4))
 * <br> 그러므로 제곱수는 약수의 개수가 홀수이다 </h2>
 */
public class P77884 {

    public static void main(String[] args) {
        SolutionP77884 s = new SolutionP77884();
        System.out.println(s.solution(13, 17));
    }

}

class SolutionP77884 {
    public int solution(int left, int right) {
        // int answer = 0;
        //
        // for (int num = left; num <= right; num++) {
        //     int count = 0;
        //     for (int j = 1; j <= num; j++) {
        //         if (num % j == 0) {
        //             count++;
        //         }
        //     }
        //
        //     if (count % 2 == 0) {
        //         answer += num;
        //     } else {
        //         answer -= num;
        //     }
        // }
        // return answer;

        /*---------제곱수로 판별-----------*/

        int answer = 0;
        for (int num = left; num <= right; num++) {
            if (num % Math.sqrt(num) == 0) {
                answer -= num;
            } else {
                answer += num;
            }
        }
        return answer;
    }
}
