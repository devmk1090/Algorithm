package com.devkproject.algorithm.lv_0

/**
 * Programmers Lv.0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120883
 * 로그인 성공?
 */

fun main() {
    val id_pw = arrayOf("prgrammer01", "15789")
    val db = arrayOf(
        arrayOf("rardss", "123"),
        arrayOf("yyoom", "1234"),
        arrayOf("meosseugi", "1234"),
        arrayOf("programmer01", "1145")
    )
    println(p120883(id_pw, db))
}

fun p120883(id_pw: Array<String>, db: Array<Array<String>>): String {
    var answer = ""
    db.map {
        if (it.contentEquals(id_pw)) {
            answer = "login"
        } else if (id_pw[0].contentEquals(it[0]) && !id_pw[1].contentEquals(it[1])) {
            answer = "wrong pw"
        } else if (!id_pw[0].contentEquals(it[0]) && !id_pw[1].contentEquals(it[1])) {
            answer = "fail"
        }
    }
    return answer
}

//find : 탐색을 앞에서부터 시작하여 조건에 만족하면 반환 없다면 null
fun p120883AS(id_pw: Array<String>, db: Array<Array<String>>): String {
    val user = db.find { it[0] == id_pw[0] } ?: return "fail"
    if (user[1] == id_pw[1])
        return "login"
    return "wrong pw"
}
