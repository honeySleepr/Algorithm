package level1;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>[카카오 인턴] 키패드 누르기</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/10</h3>
 * <br><h2>comment :</h2>
 */
public class P67256 {

    public static void main(String[] args) {
        SolutionP67256 s = new SolutionP67256();
        System.out.println(s.solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }

}

class SolutionP67256 {
    private Position l;
    private Position r;
    private Map<Integer, Position> map = new HashMap<>();
    private String mostlyUsedHand;

    public String solution(int[] numbers, String hand) {
        map.put(0, new Position(1, 0));
        map.put(7, new Position(0, 1));
        map.put(8, new Position(1, 1));
        map.put(9, new Position(2, 1));
        map.put(4, new Position(0, 2));
        map.put(5, new Position(1, 2));
        map.put(6, new Position(2, 2));
        map.put(1, new Position(0, 3));
        map.put(2, new Position(1, 3));
        map.put(3, new Position(2, 3));
        l = new Position(0, 0);
        r = new Position(2, 0);
        this.mostlyUsedHand = hand;

        StringBuilder sb = new StringBuilder();

        for (int num : numbers) {
            String chosenHand = getHand(num);

            if (chosenHand.equals("left")) {
                l = map.get(num);
                sb.append("L");
                continue;
            }
            if (chosenHand.equals("right")) {
                r = map.get(num);
                sb.append("R");
            }
        }

        return sb.toString();
    }

    private String getHand(int num) { /* {1,4,7} : 왼손, {3,6,9} : 오른손 */

        Position p = map.get(num);
        if (num == 1 || num == 4 || num == 7) {
            return "left";
        }
        if (num == 3 || num == 6 || num == 9) {
            return "right";
        }
        if (l.getDistance(p) < r.getDistance(p)) {
            return "left";
        }
        if (l.getDistance(p) > r.getDistance(p)) {
            return "right";
        }

        return mostlyUsedHand;
    }

    class Position {
        private int x;
        private int y;

        private Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private int getDistance(Position position) {
            return Math.abs(this.x - position.x) + Math.abs(this.y - position.y);
        }

    }
}
