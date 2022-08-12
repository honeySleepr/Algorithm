package level1;

/**
 * <h1>[1차] 다트 게임</h1>
 * <h3>도움!! : O</h3>
 * <h3>체감 난이도 : ⭐⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/11</h3>
 * <br><h2>comment : 반례 필수;;</h2>
 */
public class P17682 {

    public static void main(String[] args) {
        SolutionP17682 s = new SolutionP17682();
        System.out.println(s.solution("1S2D*3T")); // 37
        SolutionP17682.answer = 0;
        System.out.println(s.solution("1D2S#10S")); // 9
        SolutionP17682.answer = 0;
        System.out.println(s.solution("1D2S0T")); // 3
        SolutionP17682.answer = 0;
        System.out.println(s.solution("1S*2T*3S"));// 23
        SolutionP17682.answer = 0;
        System.out.println(s.solution("1D#2S*3S")); // 5
        SolutionP17682.answer = 0;
        System.out.println(s.solution("1T2D3D#")); // -4
        SolutionP17682.answer = 0;
        System.out.println(s.solution("1D2S3T*")); // 59
        SolutionP17682.answer = 0;
        /*----추가-----*/
        System.out.println(s.solution("10D4S10D")); // 204
    }

}

class SolutionP17682 {
    public static int answer;

    public int solution(String dartResult) {
        char[] chars = dartResult.toCharArray();
        int currentNumber = 0;
        int previousNumber = 0;

        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                answer += currentNumber;
                previousNumber = currentNumber;
                if (Character.isDigit(chars[i + 1])) {
                    currentNumber = Character.getNumericValue(chars[i]) * 10 + Character.getNumericValue(chars[i + 1]);
                    i++;
                } else {
                    currentNumber = Character.getNumericValue(chars[i]);
                }
                continue;
            }
            if (Character.isAlphabetic(chars[i])) {
                currentNumber = calculateSDT(currentNumber, chars[i]);
                continue;
            }
            currentNumber = calculateSymbol(previousNumber, currentNumber, chars[i]);
        }
        answer += currentNumber;
        return answer;
    }

    private int calculateSymbol(int preNum, int nowNum, char symbol) {
        switch (symbol) {
            case '*':
                answer += preNum;
                return nowNum * 2;
            case '#':
                return -nowNum;
            default:
                return 0;
        }
    }

    private int calculateSDT(int num, char symbol) {
        switch (symbol) {
            case 'S':
                return num;
            case 'D':
                return (int)Math.pow(num, 2);
            case 'T':
                return (int)Math.pow(num, 3);
            default:
                return 0;
        }
    }
}
