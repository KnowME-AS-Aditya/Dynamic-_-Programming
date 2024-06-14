/*
 * Data Structures and Algorithms--Greedy
 */

/**
 *
 * @author Aditya Ranjan Sahoo <adityaen.official101@gmail.com>
 */
public class LongestCommonSubSeq {
    int dp[][];
    /**
     * @param s1
     * @param s2
     * @return 
     */
    public int longest_common_subseq(String s1,String s2){
        int m=s1.length();
        int n=s2.length();
        dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
                            
        return dp[m][n];
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        LongestCommonSubSeq lcs=new LongestCommonSubSeq();
        int length = lcs.longest_common_subseq("stone","longest");
        System.out.println("LCS length: "+length);
    }
    
}
