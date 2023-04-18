package com.devkproject.algorithm.dp

import kotlin.math.max

/**
 * Dynamic Programming(동적 프로그래밍)
 * https://www.acmicpc.net/problem/11055 (가장 큰 증가하는 부분 수열)
 */

//n이 1000까지였기 때문에 O(N^2)의 시간 복잡도 통과
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }
    val dp = Array(n) { 0 }

    for (i in list.indices) {
        dp[i] = max(dp[i], list[i])
        for (j in i + 1 until list.size) {
            if (list[i] >= list[j]) continue //다음 수가 작으면 pass
            dp[j] = max(dp[j], dp[i] + list[j])
        }
    }
    println(dp.maxOrNull())
}