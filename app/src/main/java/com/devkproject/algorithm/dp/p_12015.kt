package com.devkproject.algorithm.dp

/**
 * Dynamic Programming(동적 프로그래밍)
 * https://www.acmicpc.net/problem/12015 (가장 긴 증가하는 부분 수열2)
 */

//n이 1000000이기 때문에 O(N^2)의 시간 복잡도로는 통과할 수 없음
//이분 탐색으로 시간 복잡도를 줄여 O(NlogN)으로 통과하자
//무슨 원소가 들어오느냐보다 '길이'를 구하는 것을 생각하자
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(n).run { readLine().split(" ").map { it.toInt() } }
    val dp = mutableListOf(n)

    for (item in arr) {
        if (dp.last() < item) dp.add(item) //현재 탐색 값(arr)이 dp의 last 값보다 크다면 dp에 원소 추가
        else dp[bisect(dp, item)] = item
    }

    print(dp.size - 1)
}

//이분탐색
private fun bisect(dp: MutableList<Int>, item: Int): Int {
    var low = 0
    var high = dp.lastIndex

    while (low < high) {
        val mid = (low + high) / 2

        when {
            dp[mid] == item -> return mid
            dp[mid] > item -> high = mid - 1
            else -> low = mid + 1
        }
    }
    return low
}