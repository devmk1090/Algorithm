package com.devkproject.algorithm.dp

import java.lang.Math.min

/**
 * Dynamic Programming(동적 프로그래밍)
 * https://www.acmicpc.net/problem/2839 (1로 만들기)
 */

//Hint : Bottom-Up
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = IntArray(n + 1)
    for (i in 2..n) {
        dp[i] = dp[i - 1] + 1
        if (i % 2 == 0) {
            dp[i] = dp[i].coerceAtMost(dp[i / 2] + 1)
        }
        if (i % 3 == 0){
            dp[i] = dp[i].coerceAtMost(dp[i / 3] + 1)
        }
    }
    println(dp[n])
}