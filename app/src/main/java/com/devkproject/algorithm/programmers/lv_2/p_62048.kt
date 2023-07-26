package com.devkproject.algorithm.programmers.lv_2

/**
 * Programmers Lv.2
 * https://school.programmers.co.kr/learn/courses/30/lessons/62048
 * 멀쩡한 사각형
 */

fun p62048(w: Int, h: Int): Long {
    var answer: Long = 0

    var big: Long = 0
    var small: Long = 0

    if (w > h) {
        big = w.toLong()
        small = h.toLong()
    } else {
        big = h.toLong()
        small = w.toLong()
    }

    answer = big * small - (big + small - gcd(big, small))

    return answer
}

//유클리드 호제법
//최대공약수 : 비교할 두 수를 계속 나누어 나머지가 0이되면 최대공약수
fun gcd(a: Long, b: Long): Long {
    return if (b == 0.toLong()) {
        a
    } else {
        gcd(b, a % b)
    }
}