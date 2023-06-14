package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/132267
 * 콜라 문제
 */

fun main() {
    p132267(2, 1, 20)
}

fun p132267(a: Int, b: Int, n: Int): Int {
    return recursion(a, b, n)
}

private fun recursion(a: Int, b: Int, n: Int): Int {
    if (n / a == 0) return 0
    return (n / a) * b + recursion(a, b, (n / a) * b + (n % a))
}

fun p132267AS(a: Int, b: Int, n: Int): Int {
    return (if (n > b) n - b else 0) / (a - b) * b
}