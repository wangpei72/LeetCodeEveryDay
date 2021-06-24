import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Permutation {
    /** 剑指offer 38
     *
     输入一个字符串，打印出该字符串中字符的所有排列。

     你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     */
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x){
        if(x == c.length - 1 ){//终止条件
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i,x);
            dfs(x+1);
            swap(i,x);
        }
    }
//    你知道 java里属性互换才是有效的
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();

        for (String s:
                permutation.permutation("abs")) {
            System.out.print(s + " ");
        }
    }

}
