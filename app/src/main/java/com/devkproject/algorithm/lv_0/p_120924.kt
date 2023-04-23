package com.devkproject.algorithm.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120924
 * 다음에 올 숫자
 */

fun solution(common: IntArray): Int {
    var answer: Int = 0

    val diff = common[1] - common[0]
    val sequence = common[1] + diff == common[2] //true 등차수열, false 등비수열

    if (sequence) {
        answer = common[common.lastIndex] + diff
    } else {
        val ratio = common[1] / common[0]
        answer = common[common.lastIndex] * ratio
    }
    return answer
}

//another solution
fun solution2(common: IntArray): Int {
    return if(common[1]-common[0]==common[2]-common[1]) {
        val gap = common[1]-common[0]
        common.last() + gap
    } else {
        val gap = common[1] / common[0]
        common.last() * gap
    }
}