import java.util.ArrayList;
import java.util.List;

/* 모범 답안은 숫자 전체를 다 뒤집어 비교하지 않고, 반만 뒤집어 확인하여 계산 시간을 줄였다.
* 또한 이렇게 하면 뒤집은 숫자가 int의 최대 범위를 넘어가는 경우에도 작동을 한다.
* 내 풀이는 int Max를 넘어가는 경우를 전혀 고려하지 않았는데, 일단 통과가 되었다.. 그래서 그냥 넘어간다 */
public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        p.isPalindrome(58385);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        int x2 = x;
        while (x2 > 0) {
            list.add(x2 % 10);
            x2 /= 10;
        }
        int digit = list.size();
        for (int i = 0; i < list.size(); i++) {
            x2 += (int)(list.get(i) * Math.pow(10, digit - (i + 1)));
        }
        if (x == x2) {
            return true;
        }
        return false;
    }
}
