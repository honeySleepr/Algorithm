package level1;

/**
 * <h1>가운데 글자 가져오기</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/05</h3>
 * <br><h2>comment : 속도 차이 : s.toCharArray() >>>> s.charAt() > stream
 * <br>의외로 근데 s.charAt 왜이리 느리지 </h2>
 */
public class P12903 {

    public static void main(String[] args) {
        SolutionP12903 s = new SolutionP12903();
        System.out.println(s.solution("abcde"));
        System.out.println(s.solution("abcd"));
    }

}

class SolutionP12903 {
    public String solution(String s) {
        /* s.charAt()을 쓰는게 더 빠를 줄 알았는데 훨씬 느리다?! */
        char[] chars = s.toCharArray();
        int index = 0;
        if (chars.length % 2 == 0) {
            index = chars.length / 2 - 1;
            return String.valueOf(chars[index]) + String.valueOf(chars[index + 1]);
        } else {
            index = chars.length / 2;
            return String.valueOf(chars[index]);
        }

        /* 이런식으로도 할 순 있는데 진짜 느리다 */
        //     return s.chars()
        //         .skip(index)
        //         .limit(count)
        //         .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        //         .toString();
        // }
    }
}
