package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/133499
 * 옹알이 (2)
 */

fun main() {
    val babbling = arrayOf("ayaye", "uuu", "yeye", "yemawoo", "ayaayaa")
    println(p120956AS(babbling))
}

fun p120956(babbling: Array<String>): Int {
    var answer: Int = 0

    for (i in babbling.indices) {
        if (babbling[i].contains("ayaaya") ||
            babbling[i].contains("yeye") ||
            babbling[i].contains("woowoo") ||
            babbling[i].contains("mama")
        ) {
            continue
        }
        babbling[i] = babbling[i].replace("aya", " ")
        babbling[i] = babbling[i].replace("ye", " ")
        babbling[i] = babbling[i].replace("woo", " ")
        babbling[i] = babbling[i].replace("ma", " ")
        babbling[i] = babbling[i].replace(" ", "")

        if (babbling[i].isEmpty()) answer++
    }

    return answer
}

fun p120956AS(babbling: Array<String>): Int {
    val ableRegex = "aya|ye|woo|ma".toRegex()
    val unableRegex = "ayaaya|yeye|woowoo|mama".toRegex()
    return babbling.count() {
        !it.contains(unableRegex) && it.replace(ableRegex, "").isEmpty()
    }
}