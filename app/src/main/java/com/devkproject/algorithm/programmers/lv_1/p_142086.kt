package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/142086
 * 가장 가까운 같은 글자
 */

fun p142086(s: String): IntArray {
    var answer: IntArray = intArrayOf()
    var checkList = mutableListOf<Char>()

    s.forEach {
        if (checkList.contains(it)) {
            for (i in checkList.size - 1 downTo 0) {
                if (checkList[i] == it) {
                    answer += checkList.size - i
                    checkList.add(it)
                    break
                }
            }
        } else {
            checkList.add(it)
            answer += -1
        }
    }
    return answer
}