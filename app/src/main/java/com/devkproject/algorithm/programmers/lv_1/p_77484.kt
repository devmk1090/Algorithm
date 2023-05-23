package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/77484
 * 로또의 최고 순위와 최저 순위
 */

fun p77484(lottos: IntArray, win_nums: IntArray): IntArray {
    val answer: IntArray = intArrayOf(0, 0)
    val zeroCount = lottos.filter { i -> i == 0 }.count()

    var correctCount = 0
    lottos.forEach {
        if (win_nums.contains(it))
            correctCount++
    }

    answer[0] = when (correctCount + zeroCount) {
        6 -> 1
        5 -> 2
        4 -> 3
        3 -> 4
        2 -> 5
        else -> 6
    }
    answer[1] = when (correctCount) {
        6 -> 1
        5 -> 2
        4 -> 3
        3 -> 4
        2 -> 5
        else -> 6
    }
    return answer
}

fun p77484AS(lottos: IntArray, winNums: IntArray): IntArray {
    return intArrayOf(
        (lottos.size.plus(1)) - lottos.filter { winNums.contains(it) || it == 0 }.size,
        (lottos.size.plus(1)) - lottos.filter(winNums::contains).size
    ).map { if (it > 6) it - 1 else it }.toIntArray()
}