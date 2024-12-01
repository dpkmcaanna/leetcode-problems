class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> pair = new HashSet<>();
        for(int e : arr) {
            if(pair.contains(2*e) || ((e%2 == 0) && pair.contains(e/2))) {
                return true;
            }
            pair.add(e);
        }
        return false;
    }
}