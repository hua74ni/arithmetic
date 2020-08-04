package com.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: LadderLength
 * @Description: 127. 单词接龙
 * @Author: huangdh
 * @Date: 2020/7/22 上午10:57
 */
public class LadderLength {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        String current = beginWord;
        int result = 0;

        boolean endHasFind = false;
        for (String s : wordList) {
            endHasFind = s.equals(endWord);
            if (endHasFind) break;
        }
        if (!endHasFind) return 0;

        int size = wordList.size();
        for (int i = 0; i <= size; i++) {
            if (ladder(current, endWord)) {
                return result;
            }
            if (ladder(current, wordList.get(i))) {
                result++;
                size--;
                current = wordList.get(i);
                wordList.remove(i);
                i = 0;
            }
        }
        return 0;
    }

    private boolean ladder(String current, String compare) {
        int dif = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != compare.charAt(i)) {
                dif++;
            }
        }
        return dif <= 1 ? true : false;
    }

    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dog");
        wordList.add("dot");

        System.out.println(new LadderLength().ladderLength(beginWord, endWord, wordList));
    }

}
