import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 다른 사람 Solution.. O(n)*/

public class TwoSum_better {
    public static void main(String[] args) {
        int[] answer = twoSum(new int[] {-3, 4, 3, 2}, 0);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] twoSum(int[] nums, int target) {
        //  < num , index>
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                int answer1 = numMap.get(target - nums[i]);
                int answer2 = nums[i];
                return new int[] {answer1, answer2};
            } else {
                numMap.put(nums[i], i);
            }
        }
        return null;
    }
}
