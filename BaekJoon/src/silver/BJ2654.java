package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>랜선 자르기</h1>
 * <h3>도움!! : O (반례)</h3>
 * <h3>날짜 : 2022/07/30</h3>
 * <h2>풀이 방법 : </h2>
 * <br><h2>comment :</h2>
 */
/* 반례: count > TARGET 일 때도 answer를 업데이트 해줘야하는걸 잊었다
4 4
200
200
200
1

답 : 100
*/

/* 반례 : 막대 최대 길이는 int 범위를 벗어나지 않더라도, mid를 구하는 과정에서 넘어갈 수 있기 때문에 long으로 해줘야한다
1 1
2147483647

답 : 2147483647
*/

public class BJ2654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        final int GIVEN = Integer.parseInt(split[0]);
        final int TARGET = Integer.parseInt(split[1]);
        List<Integer> list = new ArrayList<>();
        long max = 0;
        for (int i = 0; i < GIVEN; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
            if (max < num) {
                max = num;
            }
        }

        long l = 1;
        long r = max; /* 가장 큰 막대를 우측 끝으로 잡는다 */
        int count = 0;
        long answer = 0;
        while (l <= r) { /* l이 r을 넘어가기 전까지 끝까지 확인 */
            long mid = (l + r) / 2;
            count = 0;
            // 구해지는 막대 개수 계산
            for (int i = 0; i < GIVEN; i++) {
                count += list.get(i) / mid;
            }

            //System.out.println("position : " + position + " count : " + count + " l,r : "+ l +","+ r);

            if (count < TARGET) {
                r = mid - 1;
            }
            if (count >= TARGET) { /* 목표 개수보다 많은 것도 답이 될 수 있다(문제를 잘 읽자) */
                if (answer < mid) {
                    answer = mid;
                }
                l = mid + 1; /* 현재 값과 같거나 더 작은 값은 이제 볼 필요 없고, 더 큰 값 중에 가능한 값이 있는지만 검사하면 된다 */
            }
        }
        System.out.println(answer);
    }
}
/*
4 11
802
743
457
539

답 : 200
*/
