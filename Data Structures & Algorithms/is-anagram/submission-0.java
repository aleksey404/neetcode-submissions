class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> cw = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            cw.put(s.charAt(i), cw.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            cw.put(t.charAt(i), cw.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (Map.Entry e : cw.entrySet()) {
            if (!e.getValue().equals(0)) {
                return false;
            }
        }

        return true;
    }
}
