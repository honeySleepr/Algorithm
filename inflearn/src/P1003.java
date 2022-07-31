import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split("\\s");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }

        int[] count = new int[n];
        int localMax = 0;
        int globalMax = 0;

        // numbers[0] = 1;  틀린 원인 #1
        count[0] = 1;
        boolean smallerNumExists = false;

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[i] > numbers[j]) {
                    localMax = Math.max(localMax, count[j]);
                    smallerNumExists = true;
                }
            }

            if (smallerNumExists) {
                count[i] = localMax + 1;
            } else {
                count[i] = 1;
            }
            //			globalMax = Math.max(globalMax, localMax);  틀린 원인 #2
            globalMax = Math.max(globalMax, count[i]);

            // 리셋
            localMax = 0;
            smallerNumExists = false;
        }

        System.out.println(globalMax);
        P1003.solution();
    }

    /**
     * 여기에다가 설명<br>
     * 설명설명설명설명
     */
    public static void solution() {

    }
}

// 5 3 7 8 6 2 9 4
