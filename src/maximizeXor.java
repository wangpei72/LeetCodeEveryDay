public class maximizeXor {
    /**
     * 返回答案数组
     * 我最初的思路就是模拟 先实现一下最简单粗暴的思路
     * 暴力果然会超时
     */
    /**
     * 好了 这题要用字典树
     * 字典树 我来搞你了
     *
     */

    public int[] maximizeXor(int[] nums, int[][] queries) {
        myTrie myTrie = new myTrie();
        for (int val:
             nums) {
            myTrie.insert(val);
        }
        int numQ = queries.length;
        int[] ans = new int[numQ];
        for (int i = 0; i < numQ; i++) {
            ans[i] = myTrie.getMaxXorWithLimit(queries[i][0],queries[i][1]);
        }
        return ans;
    }
    class myTrie{
        static final int L = 30;
        myTrie[] children = new myTrie[2];
        int min = Integer.MIN_VALUE;

        public void insert(int val){
            myTrie node = this;
            node.min = Math.min(node.min,val);
            for (int i = L-1; i >= 0; i--) {
                int bit = (val >> i) & 1;
                if(node.children[bit] == null){
                    node.children[bit] = new myTrie();
                }
                node = node.children[bit];
                node.min = Math.min(node.min, val);
            }
        }

        public int getMaxXorWithLimit(int val, int limit){
            myTrie node = this;
            if(node.min > limit){
                return -1;
            }
            int ans = 0;
            for (int i = L-1; i >= 0; i--) {
                int bit = (val >> i) & 1;
                if(node.children[bit ^ 1] != null && node.children[bit^1].min<=limit){
                    ans |= 1 << i;
                    bit ^= 1;
                }
                node = node.children[bit];
            }
            return ans;
        }
    }
    public static int[] maximize(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;// m为行数 也就是查询次数
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int max = -1;
            for (int j = 0; j < n; j++) {
                if(nums[j] <= queries[i][1]){
                    max = Math.max(max, nums[j]^queries[i][0]);
                }
                if (max == -1)ans[i] = -1;
                else ans[i] = max;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[][] q = {{3,1},{1,3},{5,6}};
        int[] ans = maximize(nums,q);
        for (int o:
             ans) {
            System.out.print(o+" ");
        }
//        System.out.println(ans);
    }
}
