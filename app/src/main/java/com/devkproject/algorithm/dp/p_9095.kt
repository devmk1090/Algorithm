package com.devkproject.algorithm.dp

/**
 * Dynamic Programming(동적 프로그래밍)
 * https://www.acmicpc.net/problem/9095 (1,2,3 만들기)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val n = Array(t) { readLine().toInt() }
    val dp = IntArray(11)

    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for (i in 4 until 11) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    }

    n.forEach {
        println(dp[it])
    }
}