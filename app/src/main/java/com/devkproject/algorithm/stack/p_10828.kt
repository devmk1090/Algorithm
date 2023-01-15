package com.devkproject.algorithm.stack

/**
 * Stack
 * https://www.acmicpc.net/problem/10828
 */

fun main() = with(System.`in`.bufferedReader()) {
    val stack = arrayListOf<Int>()
    val n = readLine().toInt()

    for (i in 0 until  n) {
        val tmp = readLine().split(" ")
        when (tmp[0]) {
            "push" -> {
                stack.add(tmp[1].toInt())
            }
            "pop" -> {
                if (stack.isNotEmpty()) println(stack.removeAt(stack.size - 1))
                else println("-1")
            }
            "size" -> {
                println(stack.size)
            }
            "empty" -> {
                if (stack.isEmpty()) println(1)
                else println("0")
            }
            "top" -> {
                if (stack.isNotEmpty()) println(stack[stack.size - 1])
                else println("-1")
            }
        }
    }
}