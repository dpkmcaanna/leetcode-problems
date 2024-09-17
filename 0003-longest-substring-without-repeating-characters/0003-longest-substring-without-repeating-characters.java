class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> substr = new HashSet<>();
        int j = 0, len = s.length(), maxLen = 0;
        
        for(int i = 0; i < len; i ++) {

            while(substr.contains(s.charAt(i))) {
                substr.remove(s.charAt(j));
                j++;
            }

            substr.add(s.charAt(i));
            maxLen = Math.max(maxLen, i - j + 1);
        }
        return maxLen;
    }
}