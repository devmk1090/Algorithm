package com.devkproject.algorithm.bruteforce

import java.util.*

/**
 * 브루트 포스(완전탐색 알고리즘) with 백트래킹
 */
fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val m = nextInt()
    val visit = Array(n + 1) { false } //방문 체크
    val arr = Array(m) { 0 } //수열 결과
    val sb = StringBuilder()

    fun find(str: Int) {
        if (str == m) {
            arr.forEach {
                sb.append(it).append(' ')
            }
            sb.append('\n')
            return
        }

        for (i in 1 .. n) {
            //포함되지 않았다면
            if (!visit[i]) {
                //방문처리
                visit[i] = true
                arr[str] = i
                find(str + 1)
                //다른 탐색을 위해 false
                visit[i] = false
            }
        }
    }

    find(0)
    println(sb)
}