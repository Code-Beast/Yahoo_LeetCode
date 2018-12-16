// class Solution {
//     public boolean isPalindrome(int x) {
//  		String str = Integer.toString(x);

//  		int left = 0;
//  		int right = str.length() - 1;

//  		while (left < right) {
//  			if (str.charAt(left ++) != str.charAt(right --)) {
//  				return false;
//  			}
//  		}

//  		return true;
//     }
// }
// 
// // Runtime: 100ms
// // Time: O(n)
// // Space: O(1)



// class Solution {
//     public boolean isPalindrome(int x) {
//     	if (x < 0) return false;

//    		int div = 1;

//    		while (x / div >= 10) div *= 10;
       	
//        	while (x > 0) {
//        		int left = x / div;
//        		int right = x % 10;
//        		if (left != right) return false;

//        		x = (x % div) / 10;
//        		div /= 100;
//         }

//         return true;
//     }
// }

// // Runtime: 100ms
// // Time: O(n)
// // Space: O(1)



class Solution {
    public boolean isPalindrome(int x) {
    	if (x < 0 || x % 10 == 0 && x != 0) return false;
    	int revertNum = 0;

    	while (x > revertNum) {
    		revertNum = revertNum * 10 + x % 10;
    		x /= 10;
    	}

    	if (x == revertNum || revertNum / 10 == x) return true;
    	return false;
    }
}

// Runtime: 81ms
// Time: O(n)
// Space: O(1)
