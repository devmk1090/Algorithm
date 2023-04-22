package com.devkproject.algorithm.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120923
 * 연속된 수의 합
 */

fun main() {
    solution(4, 14)
}

fun solution(num: Int, total: Int): List<Int> {
    val answer = mutableListOf<Int>()
    var data = total / num

    for (i in 0 until num) {
        data += if (i % 2 == 0) -i else i
        answer.add(data)
    }
    return answer.sorted()
}