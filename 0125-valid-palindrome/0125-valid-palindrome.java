class Solution {
    public boolean isPalindrome(String s) {
        
        if(s.isEmpty()) return false;

        int i = 0, ri = s.length() - 1;

        System.out.println("string: " + s);

        while(i <= ri) {
            char lc = s.charAt(i);
            char rc = s.charAt(ri);

            if(!Character.isLetterOrDigit(lc)){
                i++;
            } else if(!Character.isLetterOrDigit(rc)){
                ri--;
            } else if(Character.toLowerCase(lc) != Character.toLowerCase(rc)) {
                return false;
            } else {
                i++; ri--;
            }
        }
        return true;
    }
}