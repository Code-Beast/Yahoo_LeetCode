/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        // Write your code here
        int celeb = 0;
        for (int i = 1; i < n; i ++) {
            if (knows(i, celeb)) continue;
            else celeb = i;
        }
        
        for (int i = 0; i < n; i ++) {
            if (i != celeb && (knows(celeb, i) || !knows(i, celeb)))
                return -1;
        }
        
        return celeb;
    }
}

// Runtime: 2400ms
// Time: O(n)
// Space: O(1)



/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        // Write your code here
        boolean[] isCelebrity = new boolean[n];
        Arrays.fill(isCelebrity, true);
        
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i == j) continue;
                if (isCelebrity[i] == true && (knows(i, j) || !knows(j, i))) {
                    isCelebrity[i] = false;
                    break;
                }
                if (isCelebrity[j] == true && (knows(j, i) || !knows(i, j))) isCelebrity[j] = false;
            }
        }
        
        for (int i = 0; i < n; i ++) {
            if (isCelebrity[i] == true) return i;
        }
        
        return -1;
    }
}

// Runtime: 2300ms
// Time: O(n)
// Space: O(n)
