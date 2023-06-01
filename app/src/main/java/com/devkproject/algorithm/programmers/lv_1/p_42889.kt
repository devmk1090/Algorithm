package com.devkproject.algorithm.programmers.lv_1

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/42889
 * 실패율
 */

fun p42889(N: Int, stages: IntArray): IntArray {
    val answer = IntArray(N)

    val indexMap: MutableMap<Int, Int> = mutableMapOf() //<스테이지, 사람수>
    val failureMap: MutableMap<Int, Double> = mutableMapOf() //<스테이지, 실패율>

    stages.forEach {
        when (indexMap.containsKey(it)) {
            true -> indexMap[it] = indexMap.getValue(it) + 1
            false -> indexMap[it] = 1
        }
    }

    var totalCount = stages.size

    for (i in 1..N) {
        when (indexMap.containsKey(i)) {
            true -> {
                failureMap[i] = (indexMap.getValue(i) / totalCount.toDouble())
                totalCount -= indexMap.getValue(i)
            }
            false -> failureMap[i] = 0.0
        }
    }

    val list = failureMap.toList().sortedByDescending { (_, value) ->
        value
    }

    for (i in 0 until N) {
        answer[i] = list[i].first
    }

    return answer
}

fun p42889AS(N: Int, stages: IntArray): IntArray {
    var stageInfo = Array(N,  { Stage(it + 1, 0, 0)})

    for (level in stages) {
        for (i in 0.until(level-1)) {
            stageInfo[i].pass++
        }
        if (level != N + 1) stageInfo[level - 1].fail++
    }
    stageInfo.sortByDescending { it.failRate }
    return stageInfo.map { it.level }.toIntArray()
}

data class Stage(var level: Int, var pass: Int, var fail: Int) {
    val failRate: Float
        get() = if (fail + pass == 0)  0.0f else (fail.toFloat()) / (pass + fail)
}