public class maxUnCrossedLines {
    public static int maxLines(int[] nums1, int[] nums2){
        int m = nums1.length, n = nums2.length;
//        开的数组大小为m+1 n+1
        int[][] dp = new int[m+1][n+1];
//        遍历时 i为1至m 1->n nums1 数组访问下标 相应地-1
        for (int i = 1; i <= m; i++) {
            int num1 = nums1[i-1];
            for (int j = 1; j <= n; j++) {
                int num2 = nums2[j-1];
                if(num1 == num2){
//                    此时数组两个相对位置相等，在i-1 j-1基础上+1
                    dp[i][j]  = dp[i-1][j-1] + 1;
                }else {
//                    dp[i-1][j]表示的 0:i-1 0:j的LCS
//                    dp[i][j-1]表示的 0:i  0:j-1的LCS
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

}
