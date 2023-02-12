package com.devkproject.algorithm.bruteforce

import kotlin.math.sqrt

/**
 * 브루트 포스(완전탐색 알고리즘)
 */
fun main() {
    val m = readLine()!!.toInt()
    val n = readLine()!!.toInt()

    for (num in solve(m, n)) {
        println(num)
    }
}

private fun solve(m: Int, n: Int): IntArray {
    val result = IntArray(2) //배열 선언
    val numList = ArrayList<Int>()

    var sqrt = sqrt(m.toFloat()).toInt() //제곱근 float > int 변환
    if (sqrt * sqrt < m) {
        sqrt++ //제곱근값 1 증가시킨후 토스
    }

    while (true) {
        val num = sqrt *sqrt
        if (num > n) {
            break
        }
        numList.add(num) //제곱근 리스트에 할당
        sqrt++
    }

    if (numList.size == 0) {
        return IntArray(1) {
            -1
        }
    }

    result[0] = numList.sum() //리스트에 들어있는 값의 합
    result[1] = numList[0] //맨처음 할당한 최소값

    return result
}