package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/67256
 * 키패드 누르기
 */

fun p67256(numbers: IntArray, hand: String): String {
    var answer = ""

    //키패드의 번호판 좌표화
    val map = mutableMapOf(
        1 to Pair(0, 3),
        2 to Pair(1, 3),
        3 to Pair(2, 3),
        4 to Pair(0, 2),
        5 to Pair(1, 2),
        6 to Pair(2, 2),
        7 to Pair(0, 1),
        8 to Pair(1, 1),
        9 to Pair(2, 1),
        0 to Pair(1, 0),
        "*" to Pair(0, 0),
        "#" to Pair(2, 0)
    )

    var currentL: Any = "*"
    var currentR: Any = "#"

    for (n in numbers) {
        when (n) {
            1, 4, 7 -> {  //1, 4, 7이라면 왼손
                answer += "L"
                currentL = n
            }
            3, 6, 9 -> {  //3, 6, 9라면 오른손
                answer += "R"
                currentR = n
            }
            else -> { //2, 5, 8, 0이라면 가까운 손을 찾아 누른다
                val position = map[n]!!

                //목표 지점부터 왼손, 오른손까지의 거리 계산
                val leftLength: Int = position.let { map[currentL]!!.distance(it) }
                val rightLength: Int = position.let { map[currentR]!!.distance(it) }

                if(leftLength > rightLength) {
                    answer += "R"
                    currentR = n
                } else if(leftLength < rightLength) {
                    answer += "L"
                    currentL = n
                } else {
                    if (hand == "right") {
                        answer += "R"
                        currentR = n
                    } else {
                        answer += "L"
                        currentL = n
                    }
                }
            }
        }
    }
    return answer
}

//거리 계산 함수
private fun Pair<Int, Int>.distance(pair: Pair<Int, Int>): Int {
    return kotlin.math.abs(this.first - pair.first) + kotlin.math.abs(this.second - pair.second)
}