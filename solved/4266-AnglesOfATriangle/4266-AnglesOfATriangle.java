// Last updated: 22/06/2026, 23:58:35
class Solution {
    public double[] internalAngles(int[] sides) {

        int a=sides[0];
        int b=sides[1];
        int c=sides[2];
        if(a+b<=c||a+c<=b||b+c<=a){
            return new double[0];
        }

        double A= Math.acos((b*b+c*c-a*a)/(2.0 *b*c));
        double B= Math.acos((a*a+c*c-b*b)/(2.0 *a*c));
        double C= Math.acos((b*b+a*a-c*c)/(2.0 *b*a));
        A=Math.toDegrees(A);
        B=Math.toDegrees(B);
        C=Math.toDegrees(C);
        double[] res={A,B,C};
        Arrays.sort(res);

        return res;
        
    }
}