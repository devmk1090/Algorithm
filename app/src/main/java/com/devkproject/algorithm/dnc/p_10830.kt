package com.devkproject.algorithm.dnc

/**
 * Divide and Conquer(분할 정복)
 * https://www.acmicpc.net/problem/10830 (행렬 제곱)
 */

fun main() {
    val mod = 1000
    val line = readln().split(" ").filter { it.isNotBlank() }
    val rowColumnCount = line.first().toInt()
    val multiplier = line.last().toLong()
    val matrix = readMatrix(rowColumnCount, rowColumnCount)

    val result = getPowerMatrixModP(matrix, multiplier, mod)

    result.printMatrix()
}

private fun readMatrix(rowCount:Int, columnCount:Int): Array<IntArray> {
    val matrix1 = Array(rowCount) { IntArray(columnCount) }
    for (m in matrix1) {
        val inputRow = readln().split(" ").map { it.toInt() }
        for (i in m.indices) {
            m[i] = inputRow[i]
        }
    }
    return matrix1
}

fun getPowerMatrixModP(matrix: Array<IntArray>, multiplier: Long, mod: Int): Array<IntArray> = when {
    multiplier == 1L -> matrix % mod
    multiplier.isOdd() -> {
        val half = getPowerMatrixModP(matrix, multiplier / 2, mod)
        half * half % mod
    }
    else -> getPowerMatrixModP(matrix, multiplier-1, mod) * matrix % mod
}

operator fun Array<IntArray>.rem(other: Int): Array<IntArray> {
    return Array(this.size) { y -> IntArray(this[y].size) { x -> this[y][x] % other  }}
}

operator fun Array<IntArray>.times(other: Array<IntArray>): Array<IntArray> {
    return Array(this.size){ y -> IntArray(other.first().size) { x -> this[y] * other.map { it[x] }.toIntArray() } }
}

operator fun IntArray.times(other: IntArray): Int {
    return this.mapIndexed { i, it -> other[i] * it }.toIntArray().sum()
}

private fun Long.isOdd(): Boolean {
    return this % 2 == 0L
}

fun Array<IntArray>.printMatrix() {
    this.forEach { row -> row.forEach { column -> print("$column ") }
        println()
    }
}