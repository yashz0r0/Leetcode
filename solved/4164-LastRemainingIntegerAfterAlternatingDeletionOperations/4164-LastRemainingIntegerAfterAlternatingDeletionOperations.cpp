// Last updated: 22/06/2026, 23:59:55
class Solution {
public:
    long long lastInteger(long long n) {
        return 1 + ((n - ((n & 1) ^ 1)) & 0xAAAAAAAAAAAAAAAALL);
        
    }
};