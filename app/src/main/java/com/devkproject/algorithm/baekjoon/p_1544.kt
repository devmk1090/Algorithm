package com.devkproject.algorithm.baekjoon

/**
 * 브루트 포스(완전탐색 알고리즘)
 */
fun main() {
    val mSet = mutableSetOf<String>() //집합처럼 중복되지 않는 고유한 원소만을 가짐
    val n = readLine()!!.toInt()

    when (n) {
        0, 1 -> println(n)
        else -> {
            repeat(n) { n -> //문자열 or 함수를 주어진 횟수만큼 반복
                if (n == 0) {
                    val temp = readLine()
                    mSet.add(temp!!) //처음 입력받는 단어이기 때문에 1개 카운트
                } else {
                    val str = readLine()
                    val strLength = str!!.length
                    var checkNew = true

                    if (mSet.map { it.length }.contains(strLength)) { //기존에 저장된 단어와 길이가 같다면
                        for (i in 0 until strLength) {
                            //앞자리수를 뒤로 붙이면서 검사
                            val temp = str.substring(i until strLength) + str.substring(0 until i)

                            if (mSet.contains(temp)) { //똑같은 단어로 판별되면 break
                                checkNew = false
                                break
                            }
                        }
                    }

                    if (checkNew) { //새로운 단어라면
                        mSet.add(str)
                    }
                }
            }
            println(mSet.size)
        }
    }
}