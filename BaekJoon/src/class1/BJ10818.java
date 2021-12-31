package class1;
/*StringTokenizer은 이전 버전과의 호환성을 위해 남겨져있는 기능이라 가능하면 split 기능 쓰는게 좋다고함.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        String[] split = br.readLine().split("\\s");
        int max = -1000000; /*이걸 0 으로 했다가 계속 틀렸다*/
        int min = 1000000;
        for (String s : split) {
            max = Math.max(max, Integer.parseInt(s));
            // max = max < Integer.parseInt(s) ? Integer.parseInt(s) : max;
            min = Math.min(min, Integer.parseInt(s));
        }
        System.out.println(min+" "+max);
    }
}
