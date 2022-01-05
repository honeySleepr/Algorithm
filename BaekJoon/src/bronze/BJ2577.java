package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ2577 {
    public static void main(String[] args) throws IOException {
        /* 숫자별로 몇번 쓰였는지 기록하기 위한 map*/
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, 0, 1, 0, 2, 0, 3, 0,
                4, 0, 5, 0, 6, 0, 7, 0, 8, 0, 9, 0));


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;
        /* A*B*C 계산해서 charAt 쓸 수 있게 String 으로 변환 */
        for (int i = 0; i < 3; i++) {
            num *= Integer.parseInt(br.readLine());
        }
        String numString = Integer.toString(num);

        int temp = 0;
        /* 숫자 사용 될 때 마다 해당 key 의 value 에 +1 */
        for (int i = 0; i < numString.length(); i++) {
            temp = numString.charAt(i) - '0';
            map.replace(temp, (map.get(temp) + 1));
        }
        for (int count : map.values())
            System.out.println(count);
    }
}
