class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int m = searchWord.length();
        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++) {
            if(words[i].length() >= searchWord.length() && words[i].substring(0, m).equals(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}