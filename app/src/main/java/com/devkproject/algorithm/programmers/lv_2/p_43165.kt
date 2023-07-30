package com.devkproject.algorithm.programmers.lv_2

/**
 * Programmers Lv.2
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * 타겟 넘버
 */

fun p43165(numbers: IntArray, target: Int): Int {
    var answer = 0

    fun dfs(index: Int, result: Int) {
        if (index == numbers.size) {
            if (result == target) {
                answer += 1
            }
        } else {
            dfs(index + 1, result + numbers[index])
            dfs(index + 1, result - numbers[index])
        }
    }

    dfs(0, 0)

    return answer
}