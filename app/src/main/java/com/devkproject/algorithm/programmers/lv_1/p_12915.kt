package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/12915
 * 문자열 내 마음대로 정렬하기
 */

fun solution(strings: Array<String>, n: Int): Array<String> {
    return strings.sortedWith(compareBy( { it[n]}, { it })).toTypedArray()
}

/**
val sortedList = list.sortedWith(
    compareBy(
        { 조건 A },
        { 조건 B }
    )
)

조건 A에 대한 정렬을 수행한 후, 조건 B에 대한 정렬을 수행한다.

compareBy()는 오름차순 정렬이고,
compareByDescending()은 내림차순 정렬

 여러개의 정렬기준과 우선순위가 필요하다면 실무에서 적극적으로 사용해보자
*/
