class Solution {
    public int countSeniors(String[] details) {
        int tens = 0, ones = 0, count = 0;
        for(String d : details) {
            tens = d.charAt(11) - '0';
            ones = d.charAt(12) - '0';
            if(10 * tens + ones > 60) {
                count++;
            }
        }
        return count;
    }
}