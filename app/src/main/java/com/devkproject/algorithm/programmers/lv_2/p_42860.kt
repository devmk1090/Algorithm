package com.devkproject.algorithm.programmers.lv_2

import java.lang.Math.min

/**
 * Programmers Lv.2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42860
 * 조이스틱
 */

fun main() {
    p42860("JEROEN")
}

fun p42860(name: String): Int {
    var vertical = 0
    var horizontal = name.length - 1 //처음부터 오른쪽 끝까지 가는 경우
    var index = 0
    for (i in 0 until name.length) {
        vertical += min(name[i] - 'A', 'Z' - name[i] + 1)

        //연속되는 A 갯수 확인
        index = i + 1
        while (index < name.length && name[index] == 'A') {
            index++
        }

        horizontal = min(horizontal, i * 2 + name.length - index) //오른쪽 갔다가 돌아와서 갈 때
        horizontal = min(horizontal, (name.length - index) * 2 + i) //왼쪽 갔다가 돌아와서 갈 때
    }

    return vertical + horizontal
}