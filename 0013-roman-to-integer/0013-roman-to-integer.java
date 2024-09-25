class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('I', 1); 
        mapping.put('V', 5); 
        mapping.put('X', 10); 
        mapping.put('L', 50); 
        mapping.put('C', 100); 
        mapping.put('D', 500);
        mapping.put('M', 1000);

        int i = 0;
        int number = 0, curr, next;
        for (; i < s.length() - 1; i++) {
            curr = mapping.get(s.charAt(i));
            next = mapping.get(s.charAt(i + 1));
            if(curr >= next) {
                number += curr;
            }else {
                number += (next - curr);
                i++;
            }
        }
        if(i == s.length() - 1){
             number += mapping.get(s.charAt(i));
        }
        return number;
    }
}