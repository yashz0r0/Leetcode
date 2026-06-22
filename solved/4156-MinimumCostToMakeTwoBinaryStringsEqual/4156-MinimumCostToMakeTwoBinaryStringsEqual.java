// Last updated: 23/06/2026, 00:00:02
import java.util.*;

public class Solution {

    public static long minimumCost(String s, String t,
                                   int flipCost, int swapCost, int crossCost) {

      

        int n = s.length();
        long cnt01 = 0, cnt10 = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0' && t.charAt(i) == '1') cnt01++;
            else if (s.charAt(i) == '1' && t.charAt(i) == '0') cnt10++;
        }

        long mismach = cnt01 + cnt10;

     
        long base = mismach * flipCost;

        long cost = 0;

       
        long pair = Math.min(cnt01, cnt10);
        long pairCost = Math.min(swapCost, 2L * flipCost);
        cost += pair * pairCost;

        long rem = mismach - 2 * pair;

      
        if (crossCost + swapCost < 2L * flipCost) {
            long artificialPairs = rem / 2;
            cost += artificialPairs * (crossCost + swapCost);
            rem -= 2 * artificialPairs;
        }

      
        cost += rem * flipCost;

     
        return Math.min(cost, base);
    }

   
}
