package level3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>베스트앨범</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎⭐︎</h3>
 * <h3>날짜 : 2022/08/25</h3>
 * <br><h2>comment :</h2>
 */
public class P42579 {
    public int[] solution(String[] genres, int[] plays) {

        /*------------내가 푼거----------------*/
        // Map<String, List<Song>> map = new HashMap<>();
        // for (int i = 0; i < genres.length; i++) {
        //     map.put(genres[i], map.getOrDefault(genres[i], new ArrayList<>()));
        //     map.get(genres[i]).add(new Song(i, plays[i]));
        // }
        //
        // return map.values().stream()
        //     .sorted((o1, o2) -> -(playsSum(o1) - playsSum(o2))) /* 각 장르에 속한 노래의 plays의 합이 큰 순으로 정렬 */
        //     .map(songList -> songList.stream().sorted((o1, o2) -> -(o1.plays - o2.plays)))/* 각 장르 내에서 plays 많은 순으로 정렬*/
        //     .map(songStream -> songStream.limit(2))/* 각 장르에서 가장 큰 두개만 선택 */
        //     .flatMapToInt(songStream -> songStream.flatMapToInt(song -> IntStream.of(song.id)))/* 하나의 IntStream으로 합침 */
        //     .toArray();

        /*-----------더 멋진 풀이-----------*/

        return IntStream.range(0, genres.length)
            .mapToObj(i -> new Song2(genres[i], i, plays[i]))
            .collect(Collectors.groupingBy(song2 -> song2.genre))
            .values().stream()
            .sorted((o1, o2) -> -(playsSum(o1) - playsSum(o2)))
            .map(songList -> songList.stream().sorted((o1, o2) -> -(o1.plays - o2.plays)).limit(2))
            .flatMapToInt(songStream -> songStream.mapToInt(song -> song.id))
            .toArray();
    }

    private <T extends Song> int playsSum(List<T> songList) { /* 제네릭 연습해봄 */
        return songList.stream()
            .mapToInt(song -> song.plays).sum();
    }

    static class Song {
        protected int id;
        protected int plays;

        public Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }

    static class Song2 extends Song { /* 제네릭 연습용 */
        private String genre;

        public Song2(String genre, int id, int plays) {
            super(id, plays);
            this.genre = genre;
        }
    }

    static class TestP42579 {
        private final P42579 p = new P42579();

        @Test
        void test1() {
            String[] input1 = {"classic", "pop", "classic", "classic", "pop", "rock"};
            int[] input2 = {500, 600, 150, 800, 2500, 1};
            int[] answer = {4, 1, 3, 0, 5};
            assertThat(p.solution(input1, input2)).isEqualTo(answer);
        }
    }
}
