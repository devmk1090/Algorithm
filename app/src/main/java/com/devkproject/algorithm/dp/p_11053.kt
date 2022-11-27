package com.devkproject.algorithm.dp

import java.util.*
import kotlin.math.max

/**
 * Dynamic Programming(동적 프로그래밍)
 * https://www.acmicpc.net/problem/11053
 */

// arr[i] > arr[j]보다 크다면 dp[i]의 값을 증가
fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val arr = IntArray(n)
    val dp = IntArray(n) { 1 } //Set default number

    val st = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }

    for (i in 0 until n) {
        for (j in 0 until i) {
            if (arr[i] > arr[j]) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }

    println(dp.maxOrNull())
}