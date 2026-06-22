// Last updated: 22/06/2026, 23:58:26
class Solution {
    public String trafficSignal(int timer) {
        

        if(timer==0){
            return "Green";
        }
       // timer=timer%90;

        if(timer==30){
            return "Orange";
        }
        if(timer>30&& timer<=90) return "Red";
        else return "Invalid";
        
    }
}