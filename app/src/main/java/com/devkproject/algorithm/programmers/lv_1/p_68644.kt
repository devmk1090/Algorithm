package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/68644
 * 두 개 뽑아서 더하기
 */

fun p68644(numbers: IntArray): IntArray {
    val answer = mutableSetOf<Int>()

    for (i in 0 until numbers.size - 1) {
        for (j in i + 1 until numbers.size) {
            answer.add(numbers[i] + numbers[j])
        }
    }
    return answer.sorted().toIntArray()
}