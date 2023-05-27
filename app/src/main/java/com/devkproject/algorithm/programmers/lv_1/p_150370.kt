package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/150370
 * 개인정보 수집 유효기간
 */

fun main() {
    val today = "2022.05.19"
    val terms = arrayOf("A 6", "B 12", "C 3")
    val privacies = arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")

    p150370(today, terms, privacies)
}

fun p150370(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
    var answer: IntArray = intArrayOf()
    val termsMap = mutableMapOf<String, Int>()

    terms.forEach {
        termsMap.put(it.split(" ")[0], it.split(" ")[1].toInt() * 28)
    }

    var todayCheck = 0
    todayCheck += today.split(".")[0].toInt() * 12 * 28
    todayCheck += today.split(".")[1].toInt() * 28
    todayCheck += today.split(".")[2].toInt()

    for (i in privacies.indices) {
        var day = 0
        day += privacies[i].split(".")[0].toInt() * 12 * 28
        day += privacies[i].split(".")[1].toInt() * 28
        day += privacies[i].split(".")[2].split(" ")[0].toInt()

        val check = privacies[i].split(".")[2].split(" ")[1]
        if(todayCheck - day >= termsMap[check]!!) answer += i + 1
    }

    return answer
}

fun p150370AS(today: String, terms: Array<String>, privacies: Array<String>) =
    privacies.indices.filter { privacies[it].split(" ").first().split("\\.".toRegex()).map(String::toInt).let { (y, m, d) -> (y * 12 * 28) + (m * 28) + d } + (terms.map { it.split(" ") }.associate { (a, b) -> a to b.toInt() }.getOrDefault(privacies[it].split(" ").last(), 0) * 28) <= today.split("\\.".toRegex()).map(String::toInt).let { (y, m, d) -> (y * 12 * 28) + (m * 28) + d } }.map { it + 1 }
