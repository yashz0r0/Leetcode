// Last updated: 23/06/2026, 00:01:35
class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int distance = 0;
        
        while (mainTank > 0) {
            
  
            mainTank--;
            distance += 10;
            
       
            if (distance % 50 == 0 && additionalTank > 0) {
                mainTank++;
                additionalTank--;
            }
        }
        
        return distance;
    }
}