class Solution {
    public String minWindow(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        if (sl < tl) {
            return "";
        }

        Map<Character, Integer> mh = new HashMap<>();

        for (char c : t.toCharArray()) {
            mh.put(c, mh.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> h = new HashMap<>();
        int l = 0;
        int r = 0;
        int minLen = Integer.MAX_VALUE;
        int index = 0;
        int match = 0;
        int mhSize = mh.size();

        while (r < sl) {
            char c = s.charAt(r);
            h.put(c, h.getOrDefault(c, 0) + 1);

            if (mh.containsKey(c) && h.get(c).equals(mh.get(c))) {
                match++;
            }

            while (match == mhSize) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    index = l;
                }

                char lc = s.charAt(l);
                h.put(lc, h.get(lc) - 1);

                if (mh.containsKey(lc) && h.get(lc) < mh.get(lc)) {
                    match--;
                }

                l++;
            }

            r++;
        }

        if (minLen == Integer.MAX_VALUE) { 
            return "";
        }

        return s.substring(index, index + minLen);
    }
}