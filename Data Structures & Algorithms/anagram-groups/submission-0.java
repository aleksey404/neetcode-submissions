class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] sym = strs[i].toCharArray();
            Arrays.sort(sym);

            String sortedSym = String.valueOf(sym);
            anagrams.computeIfAbsent(sortedSym, val -> new ArrayList<>()).add(strs[i]);
        }

        return new ArrayList<>(anagrams.values());
    }
}
