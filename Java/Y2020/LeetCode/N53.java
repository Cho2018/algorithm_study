class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum = Math.max(sum, nums[i]); // subarray 시작 위치 변경

            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }
}
