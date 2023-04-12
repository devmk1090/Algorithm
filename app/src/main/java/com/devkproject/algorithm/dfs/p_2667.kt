package com.devkproject.algorithm.dfs

/**
 * DFS, Depth First Search(깊이 우선 탐색)
 * https://www.acmicpc.net/problem/2667 (단지번호붙이기)
 */

val dx = listOf(0, 1, 0, -1)
val dy = listOf(1, 0, -1, 0)

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val graph = mutableListOf<List<String>>()

    repeat(n) {
        val houses = br.readLine().toString().split("").filter { it.isNotBlank() }
        graph.add(houses)
    }

    val visited = Array(n + 1) { Array(n + 1) { false } }
    val answer = mutableListOf<Int>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j] && graph[i][j] == "1") { //visited가 true && graph의 list값이 1이라면
                answer.add(dfs(graph, visited, i, j, n))
            }
        }
    }
    bw.write("${answer.size}\n")
    answer.sort() //오름차순 정렬
    answer.forEach {
        bw.write("$it\n")
    }
    br.close()
    bw.close()
}

fun dfs(graph: MutableList<List<String>>, visited: Array<Array<Boolean>>, x: Int, y: Int, n: Int): Int {
    //방문한곳 체크, 상하좌우 방문하지 않았고, 값이 1이라면 dfs실행
    visited[x][y] = true
    var count = 1
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in (0 until n) && ny in (0 until n) && !visited[nx][ny] && graph[nx][ny] == "1") {
            count += dfs(graph, visited, nx, ny, n) //반환값은 방문한 갯수이므로 누적
        }
    }
    return count
}