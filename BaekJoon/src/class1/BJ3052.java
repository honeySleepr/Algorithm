package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ3052 {
    public static void main(String[] args) throws IOException {
        Set<Integer> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            set.add((Integer.parseInt(br.readLine()))%42);
        }
        System.out.println(set.size());
    }
}
