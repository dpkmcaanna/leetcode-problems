class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] frq = new int[1001];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n1; i++) {
            frq[nums1[i]]++;
        }

        for(int j = 0; j < n2; j++) {
            if(frq[nums2[j]] > 0) {
                res.add(nums2[j]);
                frq[nums2[j]] = 0;
            }
        }

        int[] array = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            array[i] = res.get(i);
        return array;
    }
}