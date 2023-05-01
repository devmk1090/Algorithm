package com.devkproject.algorithm.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120882
 * 등수 매기기
 */

fun main() {
    val score = arrayOf(
        intArrayOf(80, 70),
        intArrayOf(90, 50),
        intArrayOf(40, 70),
        intArrayOf(50, 80)
    )
    p120882(score)

}

fun p120882(score: Array<IntArray>): IntArray {
    val students = score.size
    val rank = IntArray(students) { 1 }

    for (i in 0 until students) {
        for (j in 0 until students) {
            if (score[i][0] + score[i][1] < score[j][0] + score[j][1])
                rank[i]++
        }
    }
    return rank
}

fun p120882AS(score: Array<IntArray>): IntArray {
    return score.map(IntArray::average).map {
        score.map(IntArray::average).sortedDescending().indexOf(it) + 1
    }.toIntArray()
}