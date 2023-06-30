package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/81301
 * 숫자 문자열과 영단어
 */

fun p81301(s: String): Int {
    var list = mutableListOf<String>("zero","one","two","three","four","five","six","seven","eight","nine")
    var result = s

    list.forEachIndexed { index, s ->
        result = result.replace(s, index.toString())
    }
    return Integer.parseInt(result)
}