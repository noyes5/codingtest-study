class Solution { 
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        // 전체 문자를 한 번씩 사용한 길이
        int wl = words[0].length();
        int wn = words.length;
        int tl = wl * wn;

        // word 빈도 저장
        Map<String, Integer> wc = new HashMap<>();
        for (String word : words) {
            wc.put(word, wc.getOrDefault(word, 0) + 1);
        }

        // 탐색
        for (int i = 0; i < wl; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> curCount = new HashMap<>();

            while (right + wl <= s.length()) {
                String word = s.substring(right, right + wl);
                right += wl;

                if (wc.containsKey(word)) {
                    curCount.put(word, curCount.getOrDefault(word, 0) + 1);

                    // 단어 갯수 초과시 left 이동
                    while (curCount.get(word) > wc.get(word)) {
                        String lWord = s.substring(left, left + wl);
                        curCount.put(lWord, curCount.get(lWord) - 1);
                        left += wl;
                    }

                    if (right - left == tl) {
                        result.add(left);
                    }
                } else {
                    curCount.clear();
                    left = right;
                }

            }
        }
        return result;
    }
}