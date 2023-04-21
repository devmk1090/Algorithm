package com.devkproject.algorithm.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120866
 * 안전지대
 */

class P120866 {
    fun solution(board: Array<IntArray>): Int {
        var answer: Int = 0

        for(i in 0 until board.size) {
            for(j in 0 until board[i].size) {
                if(board[i][j] == 1) {
                    boomPoint(board, i, j)
                }
            }
        }
        board.forEach { it ->
            answer += it.filter { i ->
                i == 0
            }.count()
        }
        return answer
    }

    private fun boomPoint(board: Array<IntArray>, row: Int, col: Int) {
        val fromRow = if(row - 1 < 0) row else row - 1
        val toRow = if(row + 1 >= board.size) row else row + 1
        val fromCol = if(col - 1 < 0) col else col - 1
        val toCol = if(col + 1 >= board.size) col else col + 1

        for(i in fromRow..toRow) {
            for(j in fromCol..toCol) {
                if(board[i][j] == 0) {
                    board[i][j] = -1
                }
            }
        }
    }
}