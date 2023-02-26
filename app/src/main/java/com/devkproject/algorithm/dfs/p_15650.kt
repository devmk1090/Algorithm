package com.devkproject.algorithm.dfs

/**
 * BackTracking
 * https://www.acmicpc.net/problem/15650 (N과 M (2))
 */

lateinit var visited: Array<Boolean>
lateinit var array: Array<Int>

var n = 0
var m = 0

fun main() {
    val nm = readLine()!!.split(" ")
    n = nm[0].toInt()
    m = nm[1].toInt()

    array = Array(n + 1) { i -> i }
    visited = Array(n + 1) { false }

    dfs(1, 0, "")
}

fun dfs(idx: Int, len: Int, str: String) {
    if (len == m) {
        println(str)
        return
    }

    for (i in idx..n) {
        if (!visited[i]) {
            visited[i] = true

            if (len == 0)
                dfs(i, 1, array[i].toString())
            else
                dfs(i, len + 1, "$str ${array[i]}")

            visited[i] = false
        }
    }
}