package com.devkproject.algorithm.programmers.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120875
 * 평행
 */

//기울기 y2-y1 / x2-x1
fun p120875(dots: Array<IntArray>): Int {
    var answer = 0
    val arr = ArrayList<Double>()
    for (i in 0 until dots.size - 1) {
        if (answer == 1) {
            break
        }
        else {
            for (j in i + 1 until dots.size) {
                val tmp = (dots[i][1] - dots[j][1]).toDouble() / (dots[i][0] - dots[j][0]).toDouble()
                if (arr.contains(tmp)) {
                    answer = 1
                    break
                } else {
                    arr.add(tmp)
                }
            }
        }
    }
    return answer
}
