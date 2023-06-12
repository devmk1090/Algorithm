package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/12977
 * 소수 만들기
 */

fun main() {
    val nums = intArrayOf(1, 2, 3, 4)
    p12977(nums)
}

fun p12977(nums: IntArray): Int {

    var answer = 0
    for (i in 0 until nums.size - 2) {
        for (j in i + 1 until nums.size - 1) {
            for (k in j + 1 until  nums.size) {
                if (isPrime(nums[i] + nums[j] + nums[k]))
                    answer++
            }
        }
    }
    return answer
}

fun isPrime(n: Int): Boolean = n > 1 && (2 until n).none { n % it == 0 }