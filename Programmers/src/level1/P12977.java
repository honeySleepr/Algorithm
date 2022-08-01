package level1;

import java.io.IOException;

/**
 * <h1>소수 만들기</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/01</h3>
 * <h2>풀이 방법 : </h2>
 * <br><h2>comment :</h2>
 */
public class P12977 {

    public static void main(String[] args) throws IOException {
        Solution12977 s = new Solution12977();
        s.solution(new int[] {1, 2, 3, 4, 50});
    }
}

class Solution12977 {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    /* 이럴 땐 에라토스테네스의 체가 필요없다 */
    private boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
