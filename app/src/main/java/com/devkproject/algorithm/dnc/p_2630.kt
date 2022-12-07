package com.devkproject.algorithm.dnc

/**
 * Divide and Conquer(분할 정복)
 * https://www.acmicpc.net/problem/1780 (종이의 개수)
 *
 * 주어진 문제를 둘 이상의 부분 문제로 나눈 뒤 각 문제에 대한 답을 계산하고, 각 부분 문제의
 * 답으로부터 전체 문제의 답을 계산해내는 것
 */

var white = 0
var blue = 0
var board: Array<IntArray> = arrayOf()

fun main() {
    val br = System.`in`.bufferedReader()
    val n = readLine()!!.toInt()

    //Array(rows) { IntArray(cols) }
    board = Array(n) { IntArray(n) }

    repeat(n) { idx ->
        board[idx] = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    }
    for (row in board) {
        println(row.contentToString())
    }
}