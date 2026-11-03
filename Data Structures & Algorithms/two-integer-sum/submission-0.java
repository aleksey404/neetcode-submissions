class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexByNum = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (indexByNum.containsKey(target - nums[i])) {
                return new int[] {indexByNum.get(target - nums[i]), i};
            }

            indexByNum.put(nums[i], i);
        }

        return null;
    }
}
