package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 * K번째수
 */

fun p42748(array: IntArray, commands: Array<IntArray>): IntArray {
    return commands.map {
        array.slice(it[0] - 1 until it[1]).sorted()[it[2] - 1]
    }.toIntArray()
}