package com.devkproject.algorithm.programmers.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120808
 * 분수의 덧셈
 */

//유클리드 호제법
//최대공약수 : 비교할 두 수를 계속 나누어 나머지가 0이되면 최대공약수
//최소공배수 : 입력받은 두 수(a, b)의 곱에서 최대공약수를 나눈다

fun main() {
    p120808(2, 1, 4, 3)
}

fun p120808(denum1: Int, num1: Int, denum2: Int, num2: Int): IntArray {
    val gcd = gcd(num1, num2)
    val lcm = lcm(num1, num2, gcd)

    val mul1 = lcm / num1
    val mul2 = lcm / num2

    val denum = denum1*mul1 + denum2*mul2
    val gcd2 = gcd(denum, lcm)

    return intArrayOf(denum / gcd2, lcm / gcd2)
}

//최대공약수
fun gcd(a: Int, b: Int): Int {
    val maximum = a.coerceAtLeast(b)
    val minimum = a.coerceAtMost(b)

    return if (minimum == 0) {
        a.coerceAtLeast(b)
    } else {
        gcd(minimum, maximum % minimum)
    }
}

//최소공배수
fun lcm(num1: Int, num2: Int, gcd: Int): Int {
    return num1 * num2 / gcd
}