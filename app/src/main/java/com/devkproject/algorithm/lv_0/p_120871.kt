package com.devkproject.algorithm.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120871
 * 저주의 숫자3
 */

fun p120871(n: Int): Int {
    var answer = n
    var i = 1
    while (i <= answer) {
        if ((i % 3 == 0) || i.toString().contains("3")) {
            answer++
        }
        i++
    }
    return answer
}