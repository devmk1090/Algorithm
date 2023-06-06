package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * 모의고사
 */

fun main() {
    val answers = intArrayOf(1, 3, 2, 4, 2)
    p42840(answers)
}

fun p42840(answers: IntArray): IntArray {
    val userAnswers = arrayOf(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(2, 1, 2, 3, 2, 4, 2, 5),
        intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
    )
    val count = IntArray(3)
    val answer = mutableListOf<Int>()

    userAnswers.forEachIndexed { i, userValue ->
        count[i] = answers.filterIndexed { j, value ->
            value == userValue[j % userValue.size]
        }.count()
    }
    count.forEachIndexed { index, i ->
        if (count.maxOrNull() == i) answer.add(index + 1)
    }

    return answer.toIntArray()
}