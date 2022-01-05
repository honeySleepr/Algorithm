package bronze;

import java.util.List;
import java.util.Scanner;

public class BJ1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> stringList = List.of(sc.nextLine().split(" "));
        int count = stringList.size();
        for (String s : stringList) {
            if(s.equals("")){
                count--;
                break;
            }
        }
        System.out.println(count);
        }
    }
