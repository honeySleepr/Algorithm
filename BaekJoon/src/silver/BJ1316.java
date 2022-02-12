package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 그룹 단어 체커  // 애먹었던 예외처리 : aa, abac
public class BJ1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[] stringArr = new String[testCase];
        for (int i = 0; i < testCase; i++) {
            stringArr[i] = br.readLine();
        }

        int count = 0;
        for (int i = 0; i < testCase; i++) {
            if (isGroupWord(stringArr[i])) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isGroupWord(String word) {
        // 한 글자 짜리는 바로 true
        if (word.length() == 1) {
            return true;
        }
        Set<Character> charSet = new HashSet<>();
        for (int index = 0; index < word.length(); index++) {

            // 현재 마지막 글자가 아니고, 현재 글자와 다음 글자가 같다면 index ++
            if (index < word.length() - 1 && word.charAt(index) == word.charAt(index + 1)) {
                continue;
            }

            // 겹치는 단어를 만나는 경우 false
            if (charSet.contains(word.charAt(index))) {
                return false;
            }

            charSet.add(word.charAt(index));

            //현재가 마지막 단어인데 아직 까지 위의 if문에서 안걸러졌다면 true 리턴
            if (index == word.length() - 1) {
                return true;
            }
        }
        return false;
    }
}
