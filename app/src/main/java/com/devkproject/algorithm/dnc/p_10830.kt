package com.devkproject.algorithm.dnc

/**
 * Divide and Conquer(분할 정복)
 * https://www.acmicpc.net/problem/1780 (종이의 개수)
 */

var matrix: Array<IntArray> = arrayOf()

fun main() {
    val (n, b) = readLine()!!.split(" ").map(String::toInt)

    val mod = 1000
    matrix = Array(n) { IntArray(n) }

    repeat(n) { idx ->
        matrix[idx] = readLine()!!.split(" ").map { it.toInt() % mod }.toIntArray()

    }

    for (row in matrix) {
        println(row.contentToString())
    }

}

private fun pow(b: Long): Array<IntArray> {
    if (b == 1L) {
        return matrix
    }
    
}