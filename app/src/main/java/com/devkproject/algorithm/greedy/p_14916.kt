package com.devkproject.algorithm.greedy

/**
 * 그리디 알고리즘 OR 욕심쟁이 알고리즘
 */
fun main() {
    var n = readLine()!!.toInt()

    var count = 0

    while (n > 0) {

        if (n % 5 == 0) {
            count += n / 5
            break;

        } else {
            n -= 2
            count += 1
        }
    }
    println(if (n >= 0) count else -1) //1,3 > -1
}