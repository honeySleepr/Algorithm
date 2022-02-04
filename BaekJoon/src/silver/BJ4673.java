package silver;

import java.util.HashSet;
import java.util.Set;
// 셀프 넘버
public class BJ4673 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10001; i++) {
            set.add(d(i)); //
            if (!set.contains(i)) {
                // d(x) = i 를 만족하는 x 값은 항상 i 보다 작다.
                // 즉, d(i)를 set에 넣는 시점에서 set 안에 i 값이 아직 안들어있다면, 그건 애초에 i 가 셀프넘버이기 때문이다.
                sb.append(i).append("\n");
            }
        }
        sb.deleteCharAt(sb.length() - 1); // 마지막 줄바꿈("\n") 지워줌
        System.out.println(sb);

    }

    public static int d(int num) {
        int sum = num;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
