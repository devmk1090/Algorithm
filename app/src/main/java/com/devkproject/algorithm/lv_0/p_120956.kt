package com.devkproject.algorithm.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120956
 * 옹알이
 */

fun solution(babbling: Array<String>): Int {
    var answer: Int = 0
    answer = babbling.count { item ->
        item.isNotEmpty() && item.split("aya", "ye", "woo", "ma").none {
            it.isNotEmpty()
        }
    }
    return answer
}
