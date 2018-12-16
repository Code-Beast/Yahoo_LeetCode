public class Solution {

    public int maxDiff(int[][] arrays) {
        List<Integer> max = new ArrayList<>();
        for (int[] array : arrays) {
            max.add(array[array.length - 1]);
        }
        Collections.sort(max);
        int ans = Integer.MIN_VALUE;
        for (int[] array : arrays) {
            int big = array[array.length - 1] == max.get(max.size() - 1) ? max.get(max.size() - 2) : max.get(max.size() - 1);
            ans = Math.max(ans, big - array[0]);
        }
        return ans;
    }

}

// Runtime: 822ms



public class Solution {

    public int maxDiff(int[][] arrays) {
        List<Integer> maxs = new ArrayList<>();
        List<Integer> mins = new ArrayList<>();
        for (int[] array : arrays) {
            maxs.add(array[array.length - 1]);
            mins.add(array[0]);
        }
        
        int maxIdx = 0, max2Idx = 0;
        int minIdx = 0, min2Idx = 0;
        
        for (int i = 1; i < maxs.size(); i ++) {
            if (maxs.get(maxIdx) < maxs.get(i)) {
                max2Idx = maxIdx;
                maxIdx = i;
            }
            if (mins.get(minIdx) > mins.get(i)) {
                min2Idx = minIdx;
                minIdx = i;
            }
        }
        
        if (minIdx != maxIdx) return maxs.get(maxIdx) - mins.get(minIdx);
        else return Math.max(maxs.get(max2Idx) - mins.get(minIdx), maxs.get(maxIdx) - mins.get(min2Idx));
    }
}

// Runtime: 754ms
