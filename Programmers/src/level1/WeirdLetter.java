package level1;

/*단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴*/
public class WeirdLetter {
    public static void main(String[] args) {
        solution("    try  hello world    ");
    }

    public static String solution(String s) {
        /* 단어간의 공백은 한칸으로 통일 시켜서 출력하면 되는줄 알았는데, 입력된 그대로 출력해야되는거였다.
        * 즉 try 뒤에 공백이 3개 주어졌다면 그 공백 3칸도 출력값에 그대로 포함되어야하는 것이다.*/
        String[] arr = s.split("");
        StringBuilder sb = new StringBuilder();
        int wordIndex = 0;
        for (String l : arr) {
            if (l.equals(" ")) {
                wordIndex = 0;
                sb.append(l);
                continue;
            }
            if (wordIndex % 2 == 0) {
                sb.append(l.toUpperCase());
                wordIndex++;
                continue;
            }
            sb.append(l.toLowerCase());
            wordIndex++;
        }
        return sb.toString();
    }
}
