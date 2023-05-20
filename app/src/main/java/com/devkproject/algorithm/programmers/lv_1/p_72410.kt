package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/72410
 * 신규 아이디 추천
 */

fun p72410(new_id: String): String {
    return new_id
        .lowercase() //문자열을 소문자로
        .filter { it in 'a'..'z' || it in '0'..'9' || it in "-_." } //명시한 문자들만 남기고 필터링
        .replace(Regex("""\.+"""), ".") //연속된 마침표를 하나의 마침표로 대체
        .removePrefix(".") //문자열의 시작 부분에 위치한 마침표 제거
        .let { it.ifEmpty { "a" } } //문자열이 비어있다면 'a'로 대체
        .take(15) //문자열 15자이상은 제거
        .removeSuffix(".")
        .let { //문자열의 길이가 3미만이라면 마지막 문자를 가져와 부족한 길이만큼 반복하여 붙임
            if (it.length >= 3) it
            else it + it.last().toString().repeat(3 - it.length)
        }
}

fun p72410AS(newId: String): String {
    return newId
        .lowercase()
        .filter { it.isLowerCase() || it.isDigit() || it == '-' || it == '_' || it == '.' }
        .replace("[.]*[.]".toRegex(), ".")
        .removePrefix(".").removeSuffix(".")
        .let { if (it.isEmpty()) "a" else it }
        .let { if (it.length > 15) it.substring(0 until 15) else it }.removeSuffix(".")
        .let {
            if (it.length <= 2)
                StringBuilder(it).run {
                    while (length < 3) append(it.last())
                    toString()
                }
            else it
        }
}