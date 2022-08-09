package level1;

/**
 * <h1>핸드폰 번호 가리기</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/05</h3>
 * <br><h2>comment :</h2>
 */
public class P12948 {

    public static void main(String[] args) {
        SolutionP12948 s = new SolutionP12948();
        System.out.println(s.solution("01033334444"));
        System.out.println(s.solution("027778888"));
    }

}

class SolutionP12948 {
    public String solution(String phoneNumber) {
        // int length = phoneNumber.length();
        // String substring = phoneNumber.substring(length - 4, length);
        //
        // StrinBuilder sb = new StringBuilder();
        // for (int i = 0; i < length - 4; i++) {
        //     sb.append("*");
        // }
        // sb.append(substring);
        //
        // return sb.toString();

        /* Regex Lookahead(전방탐색) 활용 */
        return phoneNumber.replaceAll(".(?=.{4})", "*");
    }
}
