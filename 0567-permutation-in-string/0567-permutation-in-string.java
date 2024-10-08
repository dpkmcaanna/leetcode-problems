class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (m < n)
            return false;

        int[] m1 = new int[26];
        int[] m2 = new int[26];

        for (int i = 0; i < n; i++) {
            m1[s1.charAt(i) - 'a']++;
            m2[s2.charAt(i) - 'a']++;
        }

        if (isMatch(m1, m2)) {
            return true;
        }

        for (int i = 1; i <= m - n; i++) {
            m2[s2.charAt(i - 1) - 'a']--;
            m2[s2.charAt(i + n - 1) - 'a']++;
           
            if (isMatch(m1, m2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isMatch(int[] m1, int[] m2) {
        for (int i = 0; i < 26; i++) {
            if (m1[i] != m2[i])
                return false;
        }
        return true;
    }
}