package com.devkproject.algorithm.dp

/**
 * Dynamic Programming(동적 프로그래밍)
 * https://www.acmicpc.net/problem/2579 (계단 오르기)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { readLine().toInt() }
    val dp = Array(n) { 0 }

    when(n) {
        1 -> println(arr[0])
        2 -> println(arr[0] + arr[1])
        else -> {
            dp[0] = arr[0]
            dp[1] = arr[1] + dp[0]
            dp[2] = arr[2] + dp[0].coerceAtLeast(dp[1])

            for (i in 3 until n) {
                dp[i] = arr[i] + dp[i - 2].coerceAtLeast(dp[i - 3] + arr[i - 1])
            }
            println(dp[n - 1])
        }
    }
}