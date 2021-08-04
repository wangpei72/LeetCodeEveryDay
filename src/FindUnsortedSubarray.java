//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//
//        请你找出符合题意的 最短 子数组，并输出它的长度。



public class FindUnsortedSubarray {

    public static int findUnsortedSubarray(int[] nums){
//        将数组分成三段
//        投河尾找到保证升序的部分
//        中间进行扫描，如果发现小于前段的，说明要调整i的位置，如果中间这个数小到比前段中最小的还小，i会变成-1，也就是开头的这个指针会放到数组第一位
//        对于尾同理，如果中间段发现大于尾中的数的，说明尾部j的位置也要调整，因为她排序的话一定会插在尾部段中。
//        如果她比尾部最后一个数字还要大，那么j将会成为数组最后一个位置，j为N+1
//        这里ij出现-1 N+1是因为在数组两端设置了哨兵，一个极大的数和极小的数
        int n = nums.length;
        int MAX = 10005, MIN = -10005;
        int i = 0, j = n - 1;
        while(i < j && nums[i] <= nums[i+1])i++;
        while (i < j && nums[j-1] <= nums[j])j--;
        int l = i, r = j;
        int min = nums[i], max = nums[j];//后面会更新此两值，现在还不是真正意义上的最大最小值
        for (int u = l; u <= r; u++){
            if (nums[u] < min){//一旦出现了小于min段最大值的数，循环寻找她的上限所在下标
                while(i >= 0 && nums[u] < nums[i])i--;
                min = i >= 0? nums[i] : MIN;
            }
            if(nums[u] > max){//一旦出现大于max段最小值的数，说明后段要重排，循环寻找她的下限下标（她大于的数中最大的那个数的下标）
                while(j < n && nums[u] > nums[j])j++;
                max = j < n? nums[j] : MAX;
            }
        }
        return j == i? 0 : (j - 1) - (i + 1) + 1;
    }
}
