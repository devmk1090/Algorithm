package com.devkproject.algorithm.dnc

/**
 * Divide and Conquer(분할 정복)
 * https://www.acmicpc.net/problem/10830 (행렬 제곱)
 */

var matrix: Array<IntArray> = arrayOf()
var N = 0
val MOD = 1000

fun main() {

    val (N, b) = readLine()!!.split(" ").map(String::toInt)
    val c = b.toLong()
    matrix = Array(N) { IntArray(N) }

    repeat(N) { idx ->
        matrix[idx] = readLine()!!.split(" ").map { it.toInt() % MOD }.toIntArray()

    }

    for (row in matrix) {
        println(row.contentToString())
    }

    val result = pow(matrix, c)

    val sb = StringBuilder()
    for (i in 0 until N) {
        for (j in 0 until N) {
            sb.append(result[i][j]).append(' ')
        }
        sb.append('\n')
    }
    println(sb)
}

//행렬 제곱 분할정복 메서드
private fun pow(a: Array<IntArray> ,b: Long): Array<IntArray> {
    if (b == 1L) {
        return a
    }
    //지수를 절반으로 분할하여 재귀호출
    var ret: Array<IntArray> = pow(a, b / 2)

    ret = multiply(ret, ret)

    //만약 지수가 홀수라면 마지막에 A^1 을 곱해준다
    if (b % 2 == 1L) {
        ret = multiply(ret, matrix)
    }
    return ret
}

//a, b 행렬을 곱함
private fun multiply(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
    val ret = Array(N) { IntArray(N) }

    for (i in 0 until N) {
        for (j in 0 until N) {
            for (k in 0 until N) {
                ret[i][j] += a[i][k] * b[k][j]
                ret[i][j] %= MOD
            }
        }
    }
    return ret
}