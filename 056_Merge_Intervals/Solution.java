/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new sortByStart()); 
        List<Interval> res = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i ++) {
            if (i > 0 && res.get(res.size() - 1).end >= intervals.get(i).start) {
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, intervals.get(i).end);
            } else {
                res.add(intervals.get(i));
            }
        }
        return res;
    }
    
    private class sortByStart implements Comparator<Interval> 
    {  
        public int compare(Interval a, Interval b) 
        { 
            return a.start - b.start; 
        } 
    } 
}

// Runtime: 14ms
// Time: O(n)
// Space: O(1)
