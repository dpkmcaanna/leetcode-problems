class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0,  right = people.length - 1, botCount = 0;
        while(left <= right) {
            if((left != right) && (people[left] + people[right] <= limit)) {
                left++; 
            } 
            right--;
            botCount++;
        }
        return botCount;
    }
}