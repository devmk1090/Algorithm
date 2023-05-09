package com.devkproject.algorithm.programmers.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120861
 * 캐릭터의 좌표
 */

fun p120861(keyinput: Array<String>, board: IntArray): IntArray {
    val answer: IntArray = intArrayOf(0, 0)

    for (i in keyinput) {
        when (i) {
            "up" -> {
                if (answer[1] >= board[1] / 2) {
                    continue
                }
                answer[1] += 1
            }
            "down" -> {
                if (answer[1] <= -(board[1] / 2)) {
                    continue
                }
                answer[1] -= 1
            }
            "left" -> {
                if (answer[0] <= -(board[0] / 2)) {
                    continue
                }
                answer[0] -= 1
            }
            "right" -> {
                if (answer[0] >= board[0] / 2) {
                    continue
                }
                answer[0] += 1
            }
        }
    }
    return answer
}