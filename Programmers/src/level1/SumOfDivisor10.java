package level1;

public class SumOfDivisor10 {
    public static void main(String[] args) {
        Solution10 sol = new Solution10();
        sol.solution(12);
    }
}

class Solution10 {
    public int solution(int n) {
        int sum = 0;
        /* i < (n/2)+1 로 하는게 효율 적이다. 어차피 n/2 이후로는 약수가 없기 때문에 loop를 돌릴 필요가 없다.*/
        for (int i = 1; i < n + 1; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}