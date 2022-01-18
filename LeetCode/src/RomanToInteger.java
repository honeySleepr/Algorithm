import java.util.Map;
/*
로마 숫자를 아라비아 숫자로 변환한다 (범위는 1~3999)
*/

public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger r = new RomanToInteger();
        r.romanToInt("MCMXCIVI");
    }

    public int romanToInt(String s) {
        Map<String, Integer> symbol = Map.of(
            "I", 1,
            "V", 5,
            "X", 10,
            "L", 50,
            "C", 100,
            "D", 500,
            "M", 1000
        );
        Map<String, Integer> others = Map.of(
            "IV", 4,
            "IX", 9,
            "XL", 40,
            "XC", 90,
            "CD", 400,
            "CM", 900
        );
        int sum = 0;
        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i].equals("I") || arr[i].equals("X") || arr[i].equals(
                "C")) && i != (arr.length - 1)) {
                if (others.get((arr[i] + arr[i + 1]))!=null) {
                    sum += others.get((arr[i] + arr[i + 1]));
                    i++;
                    continue;
                }
            }
            sum += symbol.get(arr[i]);
        }
        System.out.println(sum);
        return sum;
    }
}
