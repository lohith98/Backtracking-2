// Time Complexity: O(2^n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes

import java.awt.*;
import java.util.ArrayList;

public class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        //null case
        if(s == null || s.length() == 0) {
            return result;
        }
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int idx, List<String> path) {
        // base
        if(idx == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = idx; i < s.length(); i++) {
            String sub = s.substring(idx, i+1);
            if(isPalindrome(sub)) {
                //action
                path.add(sub);
                //recurse
                helper(s, i + 1, path);
                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}