package com.devkproject.algorithm.dijkstra

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

/**
 * 백준 1916번 - 최소비용 구하기
 * https://www.acmicpc.net/problem/1916
 *
 * 문제:
 * N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다.
 * 우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다.
 * A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력하여라.
 *
 * 입력:
 * - 첫째 줄: 도시의 개수 N (1 ≤ N ≤ 1,000)
 * - 둘째 줄: 버스의 개수 M (1 ≤ M ≤ 100,000)
 * - 셋째 줄부터 M+2줄: 버스의 정보 (출발, 도착, 비용)
 * - 마지막 줄: 구하고자 하는 출발점과 도착점
 *
 * 출력:
 * - 첫째 줄: 출발 도시에서 도착 도시까지 가는데 드는 최소 비용
 *
 * 예제 입력:
 * 5
 * 8
 * 1 2 2
 * 1 3 3
 * 1 4 1
 * 1 5 10
 * 2 4 2
 * 3 4 1
 * 3 5 1
 * 4 5 3
 * 1 5
 *
 * 예제 출력:
 * 4
 */

// Comparable
// 음수: this < other (우선순위가 높음)
// 0:	this = other
// 양수: this > other (우선순위가 낮음)
data class Bus(val destination: Int, val cost: Int) : Comparable<Bus> {
    override fun compareTo(other: Bus): Int = this.cost - other.cost
}

fun dijkstra1916(graph: Array<ArrayList<Bus>>, start: Int, end: Int): Int {
    val n = graph.size
    val minCost = IntArray(n) { Int.MAX_VALUE }
    minCost[start] = 0

    val pq = PriorityQueue<Bus>() // 가장 작은 요소가 항상 큐의 맨 앞에 위치
    pq.offer(Bus(start, 0))

    while (pq.isNotEmpty()) {
        val current = pq.poll()
        val currentCity = current.destination
        val currentCost = current.cost

        // 목적지에 도달했고, 현재가 최소 비용이면 종료 (최적화)
        if (currentCity == end) {
            return currentCost
        }

        // 이미 처리된 노드 스킵
        if (currentCost > minCost[currentCity]) continue

        // 인접 도시 확인
        for (bus in graph[currentCity]) {
            val nextCity = bus.destination
            val nextCost = currentCost + bus.cost

            if (nextCost < minCost[nextCity]) {
                minCost[nextCity] = nextCost
                pq.offer(Bus(nextCity, nextCost))
            }
        }
    }

    return minCost[end]
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()  // 도시 개수
    val m = readLine().toInt()  // 버스 개수

    // 그래프 초기화 (도시 번호 1부터 시작)
    val graph = Array(n + 1) { ArrayList<Bus>() }

    // 버스 정보 입력
    repeat(m) {
        val (start, end, cost) = readLine().split(" ").map { it.toInt() }
        graph[start].add(Bus(end, cost))
    }

    // 출발점과 도착점
    val (start, end) = readLine().split(" ").map { it.toInt() }

    // 최소 비용 출력
    println(dijkstra1916(graph, start, end))
}