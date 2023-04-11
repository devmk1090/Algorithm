package com.devkproject.algorithm.bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * BFS, Breadth First Search(너비 우선 탐색)
 * https://www.acmicpc.net/problem/2178 (미로 탐색)
 */

data class Node(val x: Int, val y: Int)

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ")
    val n = nm[0].toInt()
    val m = nm[1].toInt()

    val map = Array(n) { Array(m) { 0 } }

    repeat(n) { x ->
        val line = br.readLine()
        repeat(m) { y ->
            map[x][y] = line[y] - '0' //문자를 정수형으로 변환하기 위해 '0' 빼준다.
        }
    }

    bfs(n, m, map)
}

fun bfs(n: Int, m: Int, map: Array<Array<Int>>) {
    val q: Queue<Node> = LinkedList()
    val visited = Array(n) { Array(m) { 1 } }

    q.offer(Node(0, 0)) //add는 Queue의 Capacity로 인한 오류 발생 시 Exception 발생, Offer는 발생하지 않는다.
    visited[0][0] = 1

    while (q.isNotEmpty()) {
        val target = q.poll() //remove는 더이상 빼낼 데이터가 없는 경우 NoSuchElementException을 발생시키고, poll은 null을 리턴한다.

        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            //새 좌표(nx, ny)가 맵 범위를 벗어날 경우 || 방문이 불가능한 경우(0, 벽) || 이미 방문한 좌표의 경우
            if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] == 0 || visited[nx][ny] != 1)
                continue

            q.offer(Node(nx, ny)) //해당 좌표를 큐에 집어넣는다.
            visited[nx][ny] = visited[target.x][target.y] + 1 //해당 좌표까지의 거리를 visited에 저장

            if (nx == n - 1 && ny == m - 1) { //도착점
                println(visited[nx][ny])
                break
            }
        }
    }
}