package com.devkproject.algorithm.dp

/**
 * Dynamic Programming(동적 프로그래밍)
 * https://www.acmicpc.net/problem/2839 (설탕 배달)
 */

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toInt()
    var count = 0

    while (true) {
        if (n % 5 == 0) {
            println(count + n / 5)
            return
        }

        if (n <= 0) {
            println(-1)
            return
        }
        n -= 3
        count ++

    }
}