package level1;

/**
 * <h1>문자열을 정수로 바꾸기</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/04</h3>
 * <br><h2>comment :</h2>
 */
public class P12925 {

    public static void main(String[] args) {
        SolutionP12925 s = new SolutionP12925();
        System.out.println(s.solution("-1234"));
    }

}

class SolutionP12925 {
    public int solution(String s) {
        /* 한 char 씩 떼서 int answer = answer * 10 + Character.getNumericValue(char) 형태로 구현하는게 출제 의도일 것 같은데..굳이 여기에 시간을 쓰고
         싶지 않았다 */
        return Integer.parseInt(s);
    }
}
