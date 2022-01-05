package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int kg = Integer.parseInt(br.readLine());

        if ((kg % 5) % 3 != 0) {
            /* 17 같은 경우 걸러주기 위해 */
            for (int i = kg/5-1; i > 0; i--) {
                if((kg-(5*i))%3==0){
                    System.out.println(i+(kg-(5*i))/3);
                    return;
                }
            }
            if (kg % 3 != 0) {
                System.out.println("-1");
            } else {
                System.out.println(kg/3);
            }
        } else {
            System.out.println(kg / 5 + (kg % 5) / 3);
        }
    }
}
