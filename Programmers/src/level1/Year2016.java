package level1;

import java.util.Map;

public class LeapYear9 {
    public static void main(String[] args) {
        Solution9 sol = new Solution9();
        sol.solution(2, 13);
    }
}

class Solution9 {
    public String solution(int a, int b) {
        Map<Integer, String> dayMap = Map.of(
            1, "SUN",
            2, "MON",
            3, "TUE",
            4, "WED",
            5, "THU",
            6, "FRI",
            0, "SAT");

        int start = 6; // 1월 1일 금요일

        for (int i = 1; i < a; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                start += 31;
            } else if (i == 2) {
                start += 29;  //윤달
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                start += 30;
            }
        }
        start += b - 1; // 2월 1일 - 1월 1일 = 31

        return dayMap.get((start % 7));
    }
}