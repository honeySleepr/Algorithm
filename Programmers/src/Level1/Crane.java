package Level1;

import java.util.ArrayList;
import java.util.List;

public class Crane {
    public static void main(String[] args) {
        Solution6 s = new Solution6();
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        s.solution(board, moves);
    }
}

class Solution6 {
    private List<Integer> pickedDolls = new ArrayList<>();

    public int solution(int[][] board, int[] moves) {
        this.pickedDolls = pickDoll(board, moves);

        List<Integer> stack = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < pickedDolls.size() - 1; i++) {
            if (pickedDolls.get(i).equals(pickedDolls.get(i + 1))) {
                answer++;
                pickedDolls.remove(i + 1);
                pickedDolls.remove(i);
                i = i>0 ? i-2 : i-1;
                /* i>0 인 경우 : 예를 들어 i=2일때 get(i)와 get(i+1) 이 같으면 두 값은 지워지니까 이제 새로 get(i) 자리에 들어오는 인형이 get(i-1) 하고 같은지 비교해줘야되기 때문에 i-2를 해준것*/
                /* i=0 인 경우 이전 인덱스가 없으므로 다시 i=0 부터 for문이 돌아가도록 i-1 만 해준 것*/
            }

        }
        System.out.println(answer*2);
        return answer*2;
    }

    private List<Integer> pickDoll(int[][] board, int[] moves) {

        int doll = 0;
        for (int column : moves) {
            for (int j = 0; j < board.length; j++) {
                if ((doll = board[j][column-1]) != 0) { /* 5번째 열의 index는 5-1 = 4 */
                    board[j][column-1] = 0;  /*인형 뺏으니 0으로 비워주기*/
                    pickedDolls.add(doll);
                    break;
                }
            }
        }
        return pickedDolls;
    }
}