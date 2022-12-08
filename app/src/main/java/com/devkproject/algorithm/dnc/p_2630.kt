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
    val n = readLine()!!.toInt()

    //Array(rows) { IntArray(cols) }
    board = Array(n) { IntArray(n) }

    //input 2d array data
    repeat(n) { idx ->
        board[idx] = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    }

//    for (row in board) {
//        println(row.contentToString())
//    }

    partition(0, 0, n)

    println(white)
    println(blue)
}

private fun partition(row: Int, col: Int, size: Int) {

    if (colorCheck(row, col, size)) {
        if (board[row][col] == 0) {
            white ++
        } else {
            blue ++
        }
        return
    }
    val newSize = size / 2

    //재귀호출
    partition(row, col, newSize) //2사분면
    partition(row, col + newSize, newSize) //1사분면
    partition(row + newSize, col, newSize) //3사분면
    partition(row + newSize, col + newSize, newSize) //4사분면
}

private fun colorCheck(row: Int, col: Int, size: Int): Boolean {
    val color = board[row][col]

    for (i in row until row + size) {
        for (j in col until col + size) {
            if (board[i][j] != color) {
                return false
            }
        }
    }
    return true
}