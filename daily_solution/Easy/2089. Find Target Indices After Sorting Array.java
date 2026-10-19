class Solution {
    static void sort(int[] nums) {
        if (nums.length <= 1) return;
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
    }
    static void mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, temp, left, mid);
        mergeSort(nums, temp, mid + 1, right);
        merge(nums, temp, left, mid, right);
    }
    static void merge(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        for (int p = left; p <= right; p++) {
            nums[p] = temp[p];
        }
    }
    public List<Integer> targetIndices(int[] nums, int target) {
        sort(nums);
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                result.add(i);
            }
        }
        return result;
    }
}
