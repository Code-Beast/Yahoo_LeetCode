class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        for (; k > 0; k --) {
            int length = sb.length();
            for (int i = 0; i < length - 1; i ++) {
                if (sb.charAt(i) > sb.charAt(i + 1)) {
                    sb.deleteCharAt(i);
                    break;
                }
            }
            if (length == sb.length())
                sb.deleteCharAt(length - 1);
        }
        
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

// Runtime: 34ms




class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        StringBuilder res = new StringBuilder();
        int length = num.length() - k;
        
        for (int i = 0; i < num.length(); i ++) {
            while (k > 0 && res.length() > 0 && res.charAt(res.length() - 1) > num.charAt(i)) {
                res.deleteCharAt(res.length() - 1);
                k --;
            }
            res.append(num.charAt(i));
        }
        while (res.length() > length) {
            res.deleteCharAt(res.length() - 1);
        }
        
        while (res.length() > 0 && res.charAt(0) == '0') res.deleteCharAt(0);
        
        return res.length() == 0 ? "0" : res.toString();
    }
}

// Runtime: 10ms
