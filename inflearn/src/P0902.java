import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 회의실 배정
public class P0902 {

    private static void solution(List<Meeting> list) {
        int count = 1;
        int endTime = list.get(0).end;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).start >= endTime) {
                count++;
                endTime = list.get(i).end;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Meeting> list = new ArrayList<>();
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String[] split = br.readLine().split("\\s");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            list.add(new Meeting(start, end));
        }
        Collections.sort(list);

        solution(list);

    }

    static class Meeting implements Comparable<Meeting> {

        private int start;
        private int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            return this.end - o.end;
        }

    }
}

/*
5
2 3
1 5
4 6
3 8
5 9
*/

/*
3
3 3
2 3
1 3
1 5
3 5
2 5
4 5
*/
