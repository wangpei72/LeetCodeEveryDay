public class xorGame {
    /**
     * 题目描述
     * 黑板上写着一个非负整数数组 nums[i] 。Alice 和 Bob 轮流从黑板上擦掉一个数字，Alice 先手。如果擦除一个数字后，剩余的所有数字按位异或运算得出的结果等于 0 的话，当前玩家游戏失败。 (另外，如果只剩一个数字，按位异或运算得到它本身；如果无数字剩余，按位异或运算结果为 0。）
     *
     * 并且，轮到某个玩家时，如果当前黑板上所有数字按位异或运算结果等于 0，这个玩家获胜。
     *
     * 假设两个玩家每步都使用最优解，当且仅当 Alice 获胜时返回 true。
     */
    /**
     * 解题思路： 数学推理 推理过程见我的每日一题md文件，这个实在比较特殊
     * 不用做考验思维的例子
     *
     */
    public static boolean xor(int[] nums){
        if(nums.length % 2 ==0)return true;
        int xor = 0;
        for (int i:
             nums) {
            xor ^= i;
        }
        return xor == 0;
    }
}
