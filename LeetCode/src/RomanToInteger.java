import java.util.HashMap;
import java.util.Map;
/*
로마 숫자를 아라비아 숫자로 변환한다 (범위는 1~3999)
로마숫자는 큰 수 부터 작은 수 순으로 표기하는데, 4,9,40,90,400,900 를 표현할 때만 앞자리에 작은 숫자가 오게된다.
이를 이용해서 arr[i] < arr[i+1] 일 때만 sum에서 arr[i] 에 해당되는 값을 빼주는 방식이 더 효율적이다.
*/

public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger r = new RomanToInteger();
        r.romanToInt("MCMXCIVI");
    }

    public int romanToInt(String s) {
        /*Map.of(...) 으로 추가하는 것 보다 put() 을 이용하는게 훨씬 빠르다*/
        Map<Character, Integer> symbol = new HashMap<>();
        symbol.put('I', 1);
        symbol.put('V', 5);
        symbol.put('X', 10);
        symbol.put('L', 50);
        symbol.put('C', 100);
        symbol.put('D', 500);
        symbol.put('M', 1000);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            /*charAt 인덱스가 s 범위를 넘어가면 안되기 때문에 i != 부분을 if문의 앞에 둬야한다.*/
            if (i != (s.length() - 1) && (symbol.get(s.charAt(i)) < symbol.get(
                s.charAt(i + 1)))) {
                sum -= symbol.get(s.charAt(i));
                continue;
            }
            sum += symbol.get(s.charAt(i));
        }
        return sum;
    }
}
