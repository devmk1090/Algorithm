package com.devkproject.algorithm.programmers.lv_1;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Map;

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666
 * 완주하지 못한 선수
 */

public class p_42576 {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public String p_42576(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> hashMap = new HashMap<>();

        for (String p : participant) {
            hashMap.put(p, hashMap.getOrDefault(p, 0) + 1);
        }

        for (String c: completion) {
            hashMap.put(c, hashMap.get(c) - 1);
        }

        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}
