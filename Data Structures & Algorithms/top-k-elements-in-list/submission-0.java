class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        Map<Integer, Integer> freqByValue = new HashMap();

        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            freqByValue.put(
                nums[i], 
                freqByValue.getOrDefault(nums[i], 0) + 1
            );
        }

        for (Map.Entry<Integer, Integer> e : freqByValue.entrySet()) {
            if (freq[e.getValue()] == null) {
                freq[e.getValue()] = new ArrayList<>();
            }

            freq[e.getValue()].add(e.getKey());
        }

        for (int i = freq.length - 1, j = 0; i > -1; i--) {
            if (freq[i] == null) {
                continue;
            }

            int s = 0;
            while (j < k && s < freq[i].size()) {
                result[j] = freq[i].get(s);
                j++;
                s++;
            }
        }
        return result;
    }
}
