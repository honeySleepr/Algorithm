
/* Leetcode 큰 수 뒤집기
* */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        reverseInteger.reverse(-1526780119);
    }

    public int reverse(int x) {
        int answer = 0;
        boolean minus = false;
        String numSt = Integer.toString(x);
        if (numSt.contains("-")) {
            minus = true;
            numSt = numSt.replace("-", "");
        }
        int[] numArr = new int[numSt.length()];
        for (int i = 0; i < numSt.length(); i++) {
            numArr[i] = numSt.charAt(i) - '0';
        }

        int temp = 0;
        StringBuilder sb = new StringBuilder();
        // 맨 앞과 맨 뒤부터 시작해서 서로 자리를 바꿔준다
        for (int i = 0; i < numArr.length - i; i++) {
            temp = numArr[i];
            numArr[i] = numArr[numArr.length - i - 1];
            numArr[numArr.length - i - 1] = temp;
        }
        for (int i : numArr) {
            sb.append(i);
        }
        //try-catch로 int 아닌 경우 걸러주기;;
        try {
            answer = Integer.parseInt(sb.toString());
        } catch (Exception e) {
            answer = 0;
        }
        if (minus) {
            answer *= -1;
        }
        return answer;
    }
}
