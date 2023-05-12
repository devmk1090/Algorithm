package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666
 * 성격 유형 검사하기
 */

fun main() {
    val survey = arrayOf("AN", "CF", "MJ", "RT", "NA")
    val choice = intArrayOf(5, 3, 2, 7, 5)
    p118666(survey, choice)
}

fun p118666(survey: Array<String>, choices: IntArray): String {
    var answer = ""

    val person = charArrayOf('R', 'T', 'C', 'F', 'J', 'M', 'A', 'N')
    val score = IntArray(8) { 0 }

    //값이 음수면 앞자리 문자를, 양수면 뒷자리 문자를 저장
    for (i in survey.indices) {
        score[person.indexOf(survey[i][1])] += choices[i] - 4
    }

    for (i in 0..7 step 2) {
        if (score[i] >= score[i + 1]) answer += person[i]
        else answer += person[i + 1]
    }

    return answer
}