package com.devkproject.algorithm.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120912
 * 문자열 밀기
 */

fun p120912(A: String, B: String): Int {
    val length = A.length
    if (length != B.length) {
        return -1
    }
    var data = A
    for (i in 0 until length) {
        if (data == B) {
            return i
        }
        val lastChar = data.last()
        val sb = StringBuilder(data.substring(0, length - 1))
        sb.insert(0, lastChar)
        data = sb.toString()
    }
    return -1
}

//another solution
fun p120912AS(A: String, B: String): Int = (B + B).indexOf(A)