class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int i = 0;
        int ssize = 0;
        while (i < str.length()) {
                if (Character.isDigit(str.charAt(i))) {
                    ssize = ssize * 10 + Character.digit(str.charAt(i), 10);
                    i++;
                } else {
                    i++;
                    String ts = str.substring(i, i + ssize);
                    result.add(ts);
                    i = i + ssize;
                    ssize = 0;
             }
        }
        return result;
    }
}
