package com.devkproject.algorithm.programmers.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120840
 * 구슬을 나누는 경우의 수
 */

fun p120840(balls: Int, share: Int): Int {
    var answer = 0

    answer = combination(balls, share)
    return answer
}

fun combination(balls: Int, share: Int): Int {
    return if (share == 0 || balls == share) {
        1
    } else {
        combination(balls - 1, share - 1) + combination(balls - 1, share)
    }
}