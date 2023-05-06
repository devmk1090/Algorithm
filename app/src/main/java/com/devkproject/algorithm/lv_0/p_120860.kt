package com.devkproject.algorithm.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120860
 * 직사각형 넓이 구하기
 */

fun main() {
    val dots = arrayOf(
        intArrayOf(-1, -1),
        intArrayOf(1, 1),
        intArrayOf(1, -1),
        intArrayOf(-1, 1)
    )

    p120860(dots)
}

fun p120860(dots: Array<IntArray>): Int {
    dots.sortBy { it.first() }

    val a = Math.abs(dots[0][1] - dots[1][1])
    val b = Math.abs(dots[2][0] - dots[1][0])

    return a * b
}