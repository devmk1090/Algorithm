package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 * 체육복
 */

fun main() {
    val n = 5
    val lost = intArrayOf(2, 4)
    val reserve = intArrayOf(1, 3, 5)
    p42862(n, lost, reserve)
}

fun p42862(n: Int, lost: IntArray, reserve: IntArray): Int {

    lost.sort()
    reserve.sort()

    val lostList = lost.filter { it !in reserve }.toMutableList()
    val reserveList = reserve.filter { it !in lost }.toMutableList()

    lost.forEach {
        when {
            it - 1 in reserveList -> {
                lostList.remove(it)
                reserveList.remove(it - 1)
            }
            it + 1 in reserveList -> {
                lostList.remove(it)
                reserveList.remove(it + 1)
            }
        }
    }
    return n - lostList.size
}

fun p42862AS(n: Int, lost: IntArray, reserve: IntArray): Int {

    var answer = n
    val lostSet = lost.toSet() - reserve.toSet()
    val reserveSet = (reserve.toSet() - lost.toSet()) as MutableSet

    for (i in lostSet) {
        when {
            i + 1 in reserveSet -> reserveSet.remove(i + 1)
            i - 1 in reserveSet -> reserveSet.remove(i - 1)
            else -> answer--
        }
    }
    return answer
}
