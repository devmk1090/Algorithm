package com.devkproject.algorithm.programmers.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120913
 * 잘라서 배열로 저장하기
 */

fun p120913(my_str: String, n: Int): MutableList<String> {
    val answer = mutableListOf<String>()

    for (i in my_str.indices step (n)) {
        if (my_str.length >= i + n) {
            answer.add(my_str.substring(i, i + n))
        } else {
            answer.add(my_str.substring(i))
        }
    }
    return answer
}

fun p120913AS(my_str: String, n: Int) = my_str.chunked(n).toTypedArray()