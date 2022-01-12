import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 필요없는 숫자들을 걸러내서 for문을 돌려야하는 배열의 크기를 줄이려했으나,
* 음수도 포함되어 있어서 걸러낼 수가 없었다..*/

public class TwoSum_fail {
    public static void main(String[] args) {
        int[] answer = twoSum(new int[] {-3, 4, 2, -4}, 0);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] twoSum(int[] nums, int target) {
        List<Integer[]> newNums = new ArrayList<>();
        int lastIndex = 0;
int min = 0;
int max = 0;
int temp = 0;
        for (int i : nums) {
            min = Math.min(i,min);
            max = Math.max(i,max);
            temp = min + target;
            if (i <= target-temp) {
                lastIndex = getIndex(i, nums, lastIndex);
                newNums.add(new Integer[] {i, lastIndex});
                lastIndex ++;
            }
        }
        for (int i = 0; i < newNums.size(); i++) {
            for (int j = i + 1; j < newNums.size(); j++) {
                if (newNums.get(i)[0] + newNums.get(j)[0] == target) {
                    return new int[] {newNums.get(i)[1], newNums.get(j)[1]};
                }
            }
        }
        return null;
    }

    public static int getIndex(int i, int[] nums, int lastIndex) {
        int index = 0;
        for (int j = lastIndex; j < nums.length; j++) {
            if (nums[j] == i) {
                index = j;
                break;
            }
        }
        return index;
    }
}
