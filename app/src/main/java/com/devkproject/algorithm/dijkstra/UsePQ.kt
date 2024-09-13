package com.devkproject.algorithm.dijkstra

import java.util.PriorityQueue

/**
 * Dijkstra
 * 예제 그래프
 * 0 --(10)--> 1
 * 0 --(5)--> 2
 * 1 --(1)--> 2
 * 1 --(2)--> 3
 * 2 --(9)--> 3
 * 2 --(2)--> 4
 * 3 --(4)--> 4
 * 4 --(7)--> 0
 * 4 --(6)--> 3
 */

data class Edge(val destination: Int, val weight: Int)

fun dijkstra(graph: Array<ArrayList<Edge>>, start: Int): IntArray {
    val n = graph.size
    val distances = IntArray(n) { Int.MAX_VALUE } //거리 배열 무한대로 초기화
    distances[start] = 0 //시작점 0
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }) //second 값인 거리가 작은 순서대로 정렬하고 노드 탐색
    pq.offer(Pair(start, 0)) //우선순위 큐에 요소 추가

    while (pq.isNotEmpty()) {

    }
}