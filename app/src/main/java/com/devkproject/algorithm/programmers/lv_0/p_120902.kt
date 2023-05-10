package com.devkproject.algorithm.programmers.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120902
 * 문자열 계산하기
 */

fun main() {
    p120902("3 - 4")
}

fun p120902(my_string: String): Int {
    val stringArr = my_string.split(" ".toRegex()).toTypedArray()
    var answer = stringArr[0].toInt()
    var i = 1
    while (i < stringArr.size) {
        if (stringArr[i] == "+") {
            answer += stringArr[i + 1].toInt()
        } else {
            answer -= stringArr[i + 1].toInt()
        }
        i += 2
    }
    return answer
}