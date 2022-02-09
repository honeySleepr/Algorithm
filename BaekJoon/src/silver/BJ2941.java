package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 크로아티아 알파벳 (문자열)
public class BJ2941 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arrStr = br.readLine().split("");
        int count = 0;
        String tempStr = "";

        for (int i = 0; i < arrStr.length; i++) {

            sb.append(arrStr[i]);

            if (sb.length() == 3) {
                if (sb.toString().equals("dz=")) {
                    sb.setLength(0);
                } else {
                    tempStr = sb.substring(1);
                    sb.setLength(0);
                    sb.append(tempStr); // 3 글자 중 맨 앞 알파벳 지움
                }
                count++;
            }

            if (sb.length() == 2) {
                switch (sb.toString()) {
                    case "c=":
                    case "c-":
                    case "d-":
                    case "lj":
                    case "nj":
                    case "s=":
                    case "z=":
                        count++;
                        sb.setLength(0);
                    default:
                }

            }
        }
        count += sb.length();
        System.out.println(count);

    }

}