package com.devkproject.algorithm.dp

/**
 * Dynamic Programming(동적 프로그래밍)
 * https://www.acmicpc.net/problem/2839 (피보나치 수2)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = Array(size = n + 1) { 0L }
    dp[1] = 1

    for (i in 2..n) {
        dp[i] = dp[i - 1] + dp[i -2]
    }

    println(dp[n])
}