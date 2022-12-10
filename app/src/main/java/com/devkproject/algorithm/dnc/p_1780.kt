package com.devkproject.algorithm.dnc

/**
 * Divide and Conquer(분할 정복)
 * https://www.acmicpc.net/problem/1780 (종이의 개수)
 */

var n = 0
var pGray = 0
var pWhite = 0
var pBlack = 0
var check: Array<BooleanArray> = arrayOf()
var paper: Array<IntArray> = arrayOf()

fun main () {
    val n = readLine()!!.toInt()
    paper = Array(n) { IntArray(n) }
    check = Array(n) { BooleanArray(n) }

    repeat(n) { idx ->
        paper[idx] = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    }

    for (row in paper) {
        println(row.contentToString())
    }

    partition(0, 0, n)
    println(pGray)
    println(pWhite)
    println(pBlack)
}

private fun partition(row: Int, col: Int, size: Int) {
    if (check(row, col, size)) {
        if (paper[row][col] == -1) {
            pGray ++
        } else if (paper[row][col] == 0) {
            pWhite ++
        } else {
            pBlack ++
        }
        return
    }

    val newSize = size / 3

    partition(row, col, newSize) // 왼쪽 위
    partition(row, col + newSize, newSize) // 중앙 위
    partition(row, col + 2 * newSize, newSize) // 오른쪽 위

    partition(row + newSize, col, newSize) //왼쪽 중간
    partition(row + newSize, col + newSize, newSize) // 중앙 중간
    partition(row + newSize, col + 2 * newSize, newSize) // 오른쪽 중간

    partition(row + 2 * newSize, col, newSize) // 왼쪽 아래
    partition(row + 2 * newSize, col + newSize, newSize) // 중앙 아래
    partition(row + 2 * newSize, col + 2 * newSize, newSize) // 오른쪽 아래
}

private fun check(row: Int, col: Int, size: Int): Boolean {
    val check = paper[row][col]

    for (i in row until row + size) {
        for (j in col until col + size) {
            if (paper[i][j] != check) {
                return false
            }
        }
    }
    return true
}