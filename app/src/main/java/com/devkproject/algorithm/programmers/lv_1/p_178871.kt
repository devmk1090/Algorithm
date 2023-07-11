package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 * 달리기 경주
 */

//풀이보다 어떤 자료구조를 사용해야 할지가 중요 !

//배열을 사용하면 시간 복잡도가 O(n)이기 때문에 데이터가 많아지면 시간초과가 뜬다
//HashMap을 사용하면 시간 복잡도가 O(1)이기 때문에 데이터가 많더라도 통과할 수 있다.

fun main(){
    val players = arrayOf("mumu", "soe", "poe", "kai", "mine")
    val callings = arrayOf("kai", "kai", "mine", "mine")

    p178871(players, callings)
}

fun p178871(players: Array<String>, callings: Array<String>): Array<String> {

    val rankMap = mutableMapOf<String, Int>()
    players.forEachIndexed { index, s ->
        rankMap[s] = index
    }

    callings.forEachIndexed { index, s ->
        val callRank = rankMap[s] ?: 0
        val frontPlayer = players[callRank - 1]

        players[callRank - 1] = s
        players[callRank] = frontPlayer

        rankMap[s] = callRank - 1
        rankMap[frontPlayer] = callRank
    }

    return players
}