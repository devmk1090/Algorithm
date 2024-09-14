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
        val (currentNode, currentDistance) = pq.poll()

        if (currentDistance > distances[currentNode]) continue //이미 처리된 노드 스킵

        for (edge in graph[currentNode]) { //현재 노드와 연결된 다른 노드 확인
            val newDistance = currentDistance + edge.weight

            //더 짧은 경로를 발견하면 갱신
            if (newDistance < distances[edge.destination]) {
                distances[edge.destination] = newDistance
                pq.offer(Pair(edge.destination, newDistance))
            }
        }
    }
    return distances
}

fun main() {
    val graph = Array(5) { ArrayList<Edge>() }
    graph[0].add(Edge(1, 10))
    graph[0].add(Edge(2, 5))
    graph[1].add(Edge(2, 1))
    graph[1].add(Edge(3, 2))
    graph[2].add(Edge(3, 9))
    graph[2].add(Edge(4, 2))
    graph[3].add(Edge(4, 4))
    graph[4].add(Edge(0, 7))
    graph[4].add(Edge(3, 6))

    val startNode = 0
    val distances = dijkstra(graph, startNode)

    for (i in distances.indices) {
        println("${startNode}에서 ${i}까지의 최단 거리는: ${distances[i]}")
    }
}