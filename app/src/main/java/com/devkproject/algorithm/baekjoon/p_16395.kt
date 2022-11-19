package com.devkproject.algorithm.baekjoon

/**
 * Dynamic Programming(동적 프로그래밍)
 * https://www.acmicpc.net/problem/16395
 */

fun main() {
    val n = readLine()!!.toInt()
    val k = readLine()!!.toInt()

    println(pascal(n, k))
}

//점화식 : dp[n][k] = dp[n - 1][k] + dp[n - 1][k - 1]
private fun pascal(n: Int, k: Int): Int {
    if (n == k || k == 0) return 1
    val dp = Array(n + 1) { Array(k + 1) { 0 } }
    dp[1][1] = 1
    for (i in 2 .. n) {
        for (j in 1 .. k) {
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
        }
    }
    return dp[n][k]
}