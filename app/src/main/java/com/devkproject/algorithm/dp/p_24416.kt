package com.devkproject.algorithm.dp

/**
 * Dynamic Programming(동적 프로그래밍)
 * https://www.acmicpc.net/problem/24416
 */

fun main() {
    val n = readLine()!!.toInt()
    val fib = fib(n)
    val fibonacci = fibonacci(n)
    println("$fib $fibonacci")
}

private fun fib(n: Int): Int {
    return if (n == 1 || n == 2) {
        1
    } else {
        (fib(n - 1) + fib(n - 2))
    }
}

private fun fibonacci(n: Int): Int {
    var cnt = 0
    var array = Array(n + 1) { 0 }
    array[1] = 1
    array[2] = 1

    for (i in 3 .. n) {
        array[i] = array[i - 1] + array[i - 2]
        cnt += 1
    }
    return cnt
}