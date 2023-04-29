package com.devkproject.algorithm.lv_0

import kotlin.math.abs

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120880
 * 특이한 정렬
 */

fun main() {
    val numList = intArrayOf(1, 2, 3, 4, 5, 6)
    val n = 4
    p120880(numList, n)

}
fun p120880(numlist: IntArray, n: Int): IntArray {
    val arr = ArrayList<Int>()
    for (i in numlist) {
        arr.add(Integer.valueOf(i))
    }

    arr.sortWith { a, b ->
        val absA = abs(a - n)
        val absB = abs(b- n)
        if (absA == absB) {
            if (a > b) {
                -1
            } else {
                1
            }
        } else {
            absA - absB
        }
    }
    val answer = IntArray(numlist.size)
    for (i in arr.indices) {
        answer[i] = arr[i]
    }
    return answer
}