package com.devkproject.algorithm.programmers.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120869
 * 외계어 사전
 */

fun p120869(spell: Array<String>, dic: Array<String>): Int {
    val answer =
        dic.map {
            it.toList().sorted().joinToString("")
        }.contains(spell.toList().sorted().joinToString(""))

    return if (answer) 1 else 2
}