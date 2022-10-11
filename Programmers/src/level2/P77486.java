package level2;

import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * <h1>다단계 칫솔 판매</h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : O</h2>
 * <h2>풀이 시간 : 1h30m</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/01</h2>
 * <br><h2>comment :
 * <br>이렇게 반례 만들기 어려운 문제는 반례 찾느라 애쓰지 말고 문제나 다시 꼼꼼히 읽어보는게 나을 것 같다.
 * <br>"절사"하라는걸 반올림하고 있어서 틀린거였다. 그런데 예시 테스트 케이스는 반올림으로 해도 답이 맞다;; 치사하다</h2>
 */
public class P77486 {

	Map<String, Integer> indexMap;
	int[] profit;
	String[] enroll;
	String[] referall;

	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		this.enroll = enroll;
		this.referall = referral;
		indexMap = new HashMap<>();
		for (int i = 0; i < enroll.length; i++) {
			indexMap.put(enroll[i], i);
		}

		profit = new int[enroll.length];

		for (int i = 0; i < seller.length; i++) {
			dfs(seller[i], amount[i] * 100);
		}

		return profit;
	}

	private void dfs(String member, int profit) {
		if (profit == 0 || "-".equals(member)) {
			return;
		}
		int royalty = profit / 10; /* 맞게 푼 것 같은데 답이 틀리다면 문제를 제대로 다시 좀 읽자 "원 단위에서 절사하며.." */
		this.profit[indexMap.get(member)] += profit - royalty;
		dfs(referall[indexMap.get(member)], royalty);
	}

	static class TestP77486 {

		private final P77486 p = new P77486();

		@Test
		void test1() {
			String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
			String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
			String[] seller = {"young", "john", "tod", "emily", "mary"};
			int[] amount = {12, 4, 2, 5, 10};
			int[] answer = {360, 958, 108, 0, 450, 18, 180, 1080};
			assertThat(p.solution(enroll, referral, seller, amount)).isEqualTo(answer);
		}

	}

}
