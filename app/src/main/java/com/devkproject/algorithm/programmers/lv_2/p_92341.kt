package com.devkproject.algorithm.programmers.lv_2

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * Programmers Lv.2
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 * 주차 요금 계산
 */

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    val fees = intArrayOf(180, 5000, 10, 600)
    val records = arrayOf(
        "05:34 5961 IN",
        "06:00 0000 IN",
        "06:34 0000 OUT", 
        "07:59 5961 OUT",
        "07:59 0148 IN",
        "18:59 0000 IN",
        "19:09 0148 OUT",
        "22:59 5961 IN",
        "23:00 5961 OUT"
    )
    p92341(fees, records)
}

var baseTime = 0
var baseCost = 0
var unitTIme = 0
var unitCost = 0

@RequiresApi(Build.VERSION_CODES.N)
fun p92341(fees: IntArray, records: Array<String>): IntArray {
    val answer = mutableMapOf<String, Int>()
    val map = mutableMapOf<String, Int>()

    baseTime = fees[0]
    baseCost = fees[1]
    unitTIme = fees[2]
    unitCost = fees[3]

    records.map {
        val (time, car, inout) = it.split(" ")
        val (hour, min) = time.split(":")
        val due = hour.toInt() * 60 + min.toInt()
        if (inout == "IN") {
            map[car] = due
        } else {
            var duration = due - map[car]!!
            answer[car] = answer.getOrDefault(car, 0) + duration
            map.remove(car)
        }
    }

    map.forEach { (car, t) ->
        val max = 23* 60 + 59
        val duration = max - t
        answer[car] = answer.getOrDefault(car, 0) + duration
    }

    answer.map { it.key.toInt() }
    answer.map {
        answer[it.key] = calFee(it.value)
    }

    return answer.toSortedMap(compareBy { it }).values.toIntArray()
}

fun calFee(duration: Int): Int {
    val fee = if (duration <= baseTime) {
        baseCost
    } else {
        val result = (duration - baseTime).toDouble() / unitTIme
        baseCost + Math.ceil(result).toInt() * unitCost
    }
    return fee
}