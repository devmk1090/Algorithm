package com.devkproject.algorithm.programmers.lv_2

/**
 * Programmers Lv.2
 * https://school.programmers.co.kr/learn/courses/30/lessons/60057
 * 문자열 압축
 */

fun p60057(s: String): Int {
    var answer = Integer.MAX_VALUE;

    //압축 단위
    for (i in 1 until s.length) {
        var result = "";
        var str = "";
        var nextStr = "";
        var count = 1;

        //문자열 인덱스
        for (j in s.indices step i) {
            str = s.substring(j, j + i);
            if (j + 2 * i <= s.length) {
                nextStr = s.substring(j + i, j + 2 * i);
            } else {
                nextStr = s.substring(j + i);
            }

            if (str.length == nextStr.length) {
                if (str.equals(nextStr)) {
                    count++;
                } else {
                    if (count != 1) result += count;
                    result += str;

                    count = 1;
                }
            } else {
                //마지막 종료 지점
                if (count != 1) {
                    result += count;
                    count = 1;
                }
                result += (str + nextStr);
                break;
            }
        }

        if (count != 1) {
            result += count;
            result += str;
        }

        answer = Math.min(answer, result.length);
    }

    return if(answer == Integer.MAX_VALUE) 1 else answer
}