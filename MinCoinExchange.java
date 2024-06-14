/*
 * Data Structures and Algorithms--Greedy
 */

/**
 *
 * @author Aditya Ranjan Sahoo <adityaen.official101@gmail.com>
 */
import java.util.*;
public class MinCoinExchange {

    /**
     * @param args the command line arguments
     */
    public static int minCoinExc(int [] coins, int amount){
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        
        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(i-coin>=0)
                     dp[i]=Math.min(dp[i], dp[i-coin]+1);
                
            }
        } return dp[amount]>amount?-1 : dp[amount];
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int coins[]={1,3,4};
        int amount=6;
        System.out.println("Min coins:: "+minCoinExc(coins,amount));
    }
    
}
