public class totalHammingDistance {
    public static int totalDis(int[] nums){
        int ans = 0;
        for (int x = 31; x >= 0; x--) {
            int s0 = 0, s1 = 0;
            for (int u : nums) {
                if (((u >> x) & 1) == 1) {
                    s1++;
                } else {
                    s0++;
                }
            }
            ans += s0 * s1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]  nums = {4, 14, 4};
        System.out.println(totalDis(nums));
    }
}
//以下是没有考虑清楚s0 s1下标含义的错误代码
//    int n = nums.length;
//    int[] s0 = new int[n];
//    int[] s1 = new int[n];
//    int ret = 0;
//        for (int i = 0; i < n; i++) {
//        while (nums[i] != 0){
//        int res = nums[i] & 1;
//        if(res == 1){
//        s1[i]++;
//        }else {
//        s0[i]++;
//        }
//        nums[i]>>=1;
//        }
//        }
//        for (int i = 0; i < n; i++) {
//        ret += s0[i]*s1[i];
//        }
//        return ret;