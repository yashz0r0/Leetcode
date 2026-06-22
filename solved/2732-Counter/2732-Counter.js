// Last updated: 23/06/2026, 00:01:45
/**
 * @param {number} n
 * @return {Function} counter
 */
 
var createCounter = function(n) {
    n=n-1
    return function() {
        
        return n=n+1;
        
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */