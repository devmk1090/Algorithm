package com.devkproject.algorithm.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120812
 * 최빈값 구하기
 */

fun main() {

}
fun p120812(array: IntArray): Int {
    var answer = 0
    val countArray = IntArray(1001)

    for (i in array.indices) {
        countArray[array[i]]++ //각 숫자의 출현 횟수를 증가시킴
    }

    var max = 0
    for (i in countArray.indices) {
        if (countArray[i] > max) {
            max = countArray[i]
            answer = i
        }
    }

    var maxCount = 0
    for (i in countArray.indices) {
        if (countArray[i] == max) maxCount++
        if (maxCount > 1) return -1
    }
    return answer
}

//another solution
fun p120812AS(array: IntArray): Int {
    val list = array.groupBy { it }.entries.sortedByDescending { (_, value) -> value.size }
    return if (list.size > 1 && list[0].value.size == list[1].value.size) -1 else list[0].key
}