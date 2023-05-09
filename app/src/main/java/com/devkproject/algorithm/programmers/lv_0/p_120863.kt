package com.devkproject.algorithm.programmers.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120863
 * 다항식 더하기
 */

fun p120863(polynomial: String): String {
    var xCount = 0 //x항 계수
    var num = 0 //상수항

    for (i in polynomial.split(" ".toRegex())) {
        if (i.contains("x")) {
            //x만 있으면 계수가 1
            xCount += if (i == "x") 1 else i.replace("x".toRegex(), "").toInt()
        } else if (i != "+") {
            num += i.toInt()
        }
    }
    return (if (xCount != 0) if (xCount > 1) "${xCount}x" else "x" else "") + //x항 출력
            if (num != 0) (if (xCount != 0) " + " else "") + num
            else if (xCount == 0) "0"
            else ""
}
