package com.devkproject.algorithm.dfs

/**
 * DFS, Depth First Search(깊이 우선 탐색)
 * https://www.acmicpc.net/problem/2606 (바이러스)
 */

private lateinit var arr: Array<IntArray> //연결된 컴퓨터의 쌍
private lateinit var visit: BooleanArray //방문 여부
private var virus: Int = 0 //바이러스 걸린 컴퓨터의 개수

fun main() {
    val com = readLine()!!.toInt() //총 컴퓨터 개수
    val link = readLine()!!.toInt() //연결된 컴퓨터 쌍의 개수

    arr = Array(com + 1) { IntArray(com + 1) } //1부터 시작하기 때문에 편의를 위해
    visit = BooleanArray(com + 1)

    for (i in 0 until link) {
        val (n , m) = readLine()!!.split(' ').map(String::toInt)
        arr[n][m] = 1
        arr[m][n] = 1
    }
    dfs(1)

    print(virus)
}

private fun dfs(n: Int) {
    if (n != 1) { //1번 컴퓨터 제외
        virus ++
    }
    visit[n] = true

    for (i in 1 until arr.lastIndex + 1) {
        if (!visit[i] && arr[n][i] == 1) {
            dfs(i)
        }
    }
}