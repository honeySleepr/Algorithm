package level1;

/**
 * <h1></h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/05</h3>
 * <br><h2>comment : regex(정규표현식) 멋졍. 그런데 toCharArray() 방법 보다는 느리다 </h2>
 */
public class P12918 {

    public static void main(String[] args) {
        SolutionP12918 s = new SolutionP12918();
        System.out.println(s.solution("a234"));
        System.out.println(s.solution("1234"));
    }

}

class SolutionP12918 {
    public boolean solution(String s) {
        // for (char c : s.toCharArray()) {
        //     if (!Character.isDigit(c)) {
        //         return false;
        //     }
        // }
        // return s.length() == 4 || s.length() == 6;

        /*---------오오 정규표현식 쓰는 방법!!----------*/
        return s.matches("\\d{4}|\\d{6}");
    }

}
