package com.arithmetic.swordo;

import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: LengthOfLongestSubstring
 * @Description: 48. 最长不含重复字符的子字符串
 * @Author: huangdh
 * @Date: 2020/8/19 上午9:45
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String str = "au";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(str));
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int start = -1;
        int end;
        Map<Character, Integer> map = new HashMap<>();
        for (end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)));
            }
            map.put(s.charAt(end), end);
            res = Math.max(res, end - start);
        }
        return res;
    }

}
