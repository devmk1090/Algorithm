package com.devkproject.algorithm.lv_0

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    val idList: Array<String> = arrayOf("muzi", "frodo", "apeach", "neo")
    val report: Array<String> = arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi")
    p92334(idList, report, 2)
}

@RequiresApi(Build.VERSION_CODES.N)
fun p92334(id_list: Array<String>, report: Array<String>, k: Int): IntArray {

    val reportMap = mutableMapOf<String, Int>()
    //distinct() 함수를 사용하여 중복제거
    report.distinct().forEach {
        //공백을 기준으로 잘라내고 신고당한 사람 리스트에 저장
        val key = it.split(' ')[1]
        //reportMap에 기존값이 있으면 +1, 없다면 저장하고 +1
        reportMap[key] = reportMap.getOrDefault(key, 0) + 1
    }
    //k번이 이상 신고된 유저 리스트에 저장
    val blockList = reportMap.filterValues { it >= k }
    //answerMap Int 초기화
    val answerMap = mutableMapOf<String, Int>()
    id_list.forEach {
        answerMap[it] = 0
    }
    //메일을 보내기 위해 신고한 사람을 찾는다
    report.distinct().forEach {
        val key = it.split(' ')[0]
        if (blockList.contains(it.split(' ')[1])) {
            answerMap[key] = answerMap.getOrDefault(key, 0) + 1
        }
    }
    return answerMap.values.toIntArray()
}