package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//달팽이는 올라가고 싶다
public class BJ2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputString = br.readLine().split("\\s+");
        int A = Integer.parseInt(inputString[0]);
        int B = Integer.parseInt(inputString[1]);
        int V = Integer.parseInt(inputString[2]);
        int diff = A - B;

        int x = (V - A) / diff;
        if ((V - A) % diff != 0) { // if((float)x != ((float)V - A) / diff) 이건 왜 틀리지..?
            x++;
        }
        System.out.println(x + 1);

    }
}
