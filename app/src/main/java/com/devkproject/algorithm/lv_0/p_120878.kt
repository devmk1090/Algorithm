package com.devkproject.algorithm.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120878
 * 유한소수 판별하기
 */

fun main() {
    p120878(12, 21)
}

fun p120878(a: Int, b: Int): Int {
    var calB = b / gcd120878(a, b)
    while (calB != 1) {
        calB /= if (calB % 2 == 0) {
            2
        } else if (calB % 5 == 0) {
            5
        } else {
            return 2
        }
    }
    return 1
}

//유클리드 호제법(최대공약수 구하기)
private fun gcd120878(a: Int, b: Int): Int {
    return if (b == 0) {
        a
    } else {
        gcd120878(b, a % b)
    }
}