package com.devkproject.algorithm.programmers.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120884
 * 치킨 쿠폰
 */

fun p120884(chicken: Int): Int {
    var answer = 0
    var coupon = chicken

    while (coupon >= 10) {
        answer += coupon / 10
        coupon = coupon / 10 + coupon % 10
    }
    return answer
}