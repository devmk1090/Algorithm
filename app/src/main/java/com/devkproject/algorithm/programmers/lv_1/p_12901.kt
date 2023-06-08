package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/12901
 * 2016년
 */

fun main() {
    p12901(5, 24)
}

fun p12901(a: Int, b: Int): String {
    val dayOfWeek = listOf("THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED") //1월1일은 금요일이기 때문에 나눴을때 0번째는 목요일
    val year = listOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    val totalDay = (0 until a - 1).sumOf { year[it] } + b
    return dayOfWeek[totalDay % 7]
}