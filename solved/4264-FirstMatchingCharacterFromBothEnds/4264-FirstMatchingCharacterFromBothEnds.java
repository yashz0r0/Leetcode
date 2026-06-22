// Last updated: 22/06/2026, 23:58:36
class Solution {
    public int firstMatchingIndex(String s) {
        char arr[] = s.toCharArray();
        int n=s.length();

        for(int i=0;i<n;i++){
            if(arr[i]==arr[n-i-1])return i;
        }
        return -1;
    }
}