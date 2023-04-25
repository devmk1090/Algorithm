package com.devkproject.algorithm.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120907
 * OX퀴즈
 */

//split 함수로 띄어쓰기를 기준으로 분리하여 배열에 넣고
//0, 2, 4번째 숫자계산

fun main() {
    val list: Array<String> = arrayOf("19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2")
    solution(list).map {
        print(it)
    }
}

fun solution(quiz: Array<String>): Array<String?> {
    val answer = arrayOfNulls<String>(quiz.size)
    for (i in quiz.indices) {
        val arr = quiz[i].split(" ".toRegex()).toTypedArray()
        if (arr[1] == "+") {
            if (arr[0].toInt() + arr[2].toInt() == arr[4].toInt()) {
                answer[i] = "O"
            } else {
                answer[i] = "X"
            }
        } else if (arr[1] == "-") {
            if (arr[0].toInt() - arr[2].toInt() == arr[4].toInt()) {
                answer[i] = "O"
            } else {
                answer[i] = "X"
            }
        }
    }
    return answer
}

//another solution
fun solution2(quiz: Array<String>): Array<String> {
    return quiz.map { s: String ->
        val arr = s.trim().split(" ".toRegex())
        if (arr[1] == "+" && arr[0].toInt() + arr[2].toInt() == arr[4].toInt() || arr[0].toInt() - arr[2].toInt() == arr[4].toInt()) "O" else "X"
    }.toTypedArray()
}