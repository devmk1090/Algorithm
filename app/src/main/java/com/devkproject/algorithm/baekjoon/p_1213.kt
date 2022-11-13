package com.devkproject.algorithm.baekjoon

/**
 * 그리디 알고리즘 OR 욕심쟁이 알고리즘
 *
 * 팰린드롬(palindrome): 앞뒤를 뒤집어도 똑같은 문자열
 *
 * if 입력 받은 글자가 짝수
 * 홀수개를 가진 글자가 0개 > 불가능
 * 홀수개를 가진 글자가 없다면 > 가능
 *
 * if 입력 받은 글자가 홀수
 * 홀수개를 가진 글자가 없거나 2개 이상 > 불가능
 * 홀수개를 가진 글자가 딱 하나 > 가능
 */

var eventCnt = 0
var oddCnt = 0
var nameLength = 0
val intArr = IntArray(26) { 0 }

fun main() {
    val name = readLine()!!.toString()
    nameLength = name.length

    //intArr[0] > 'A'의 갯수, intArr[25] > 'Z'의 갯수
    name.forEach { intArr[it - 'A']++ }

    //짝수, 홀수 글자수 카운트
    intArr.forEach {
        if (it != 0) {
            if (it % 2 == 0)
                eventCnt++
            else
                oddCnt++
        }
    }

    if (nameLength % 2 == 0) { //짝수일때
        if (oddCnt != 0) { //불가능
            println("I'm Sorry Hansoo")
            return
        } else {
            println(solve())
        }
    } else { //홀수일때
        if (oddCnt != 1) { //불가능
            println("I'm Sorry Hansoo")
            return
        } else {
            println(solve())
        }
    }
}

fun solve(): String {
    var result = ""

    when (nameLength % 2) {
        0 -> {
            for (i in intArr.indices) { //'A'부터 'Z'까지 탐색
                if (intArr[i] != 0) {
                    repeat(intArr[i] / 2) { //반만 result 변수에 저장
                        result += ('A' + i)
                    }
                }
            }
            result += result.reversed() //절반은 거꾸로 저장
        }
        else -> { //홀수는 단 하나만 존재해야 한다
            var oddIdx = 0 //한개의 홀수를 저장할 변수 선언

            for (i in intArr.indices) {
                if (intArr[i] != 0) {
                    if (intArr[i] % 2 == 0) {
                        repeat(intArr[i] / 2) {
                            result += ('A' + i)
                        }
                    } else {
                        if (intArr[i] > 2) { //홀수개를 가진 글자의 갯수가 3이상일때
                            repeat(intArr[i] / 2) {
                                result += ('A' + i)
                            }
                        }
                        oddIdx = i
                    }
                }
            }
            //홀수개를 가진 글자를 가운데 위치
            //ex) 홀수갯수 < 2 : AAAABBC > 'AAB' + 'C' + 'BAA'
            //ex) 홀수갯수 > 2 : AAAABBCCC > 'AABC' + 'C' + 'CBAA'
            result += (('A' + oddIdx) + result.reversed())
        }
    }
    return result
}