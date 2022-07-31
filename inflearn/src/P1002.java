import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int steps = Integer.parseInt(br.readLine());
        int[] arr = new int[steps + 1];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= steps; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        System.out.println(arr[steps] + arr[steps - 1]);

    }
}
