public class StrangePrinter {
    public static int sPrinter(String s){
        //这是官方的代码
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n-1; i >= 0 ; i--) {
            f[i][i] = 1;
            for (int j = i+1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    f[i][j] = f[i][j-1];
                }
                else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min,f[i][k] + f[k+1][j]);
                    }
                    f[i][j] = min;
                }
            }
        }
        return f[0][n-1];
    }
}
