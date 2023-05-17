package com.devkproject.algorithm.programmers.lv_1;

import java.util.HashSet;

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 * 폰켓몬
 */

public class p_1845 {
    public int p_1845(int[] nums) {
        int max = nums.length / 2;

        //HashSet : null 허용, 중복을 허용하지 않음
        HashSet<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        //중복을 제거한 numSet 크기가 max보다 크면 max를, 작으면 numSet의 크기 리턴
        if (numSet.size() > max) {
            return max;
        } else {
            return numSet.size();
        }
    }
}
