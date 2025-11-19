package com.devkproject.algorithm.dijkstra

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

/**
 * 백준 1753번 - 최단경로
 * https://www.acmicpc.net/problem/1753
 *
 * 문제: 방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오.
 * 단, 모든 간선의 가중치는 10 이하의 자연수이다.
 *
 * 입력:
 * - 첫째 줄: 정점의 개수 V(1≤V≤20,000), 간선의 개수 E(1≤E≤300,000)
 * - 둘째 줄: 시작 정점의 번호 K(1≤K≤V)
 * - 셋째 줄부터 E개의 줄: u, v, w (u에서 v로 가는 가중치 w인 간선)
 *
 * 출력:
 * - i번째 줄에 i번 정점으로의 최단 경로의 값을 출력한다.
 * - 경로가 존재하지 않으면 INF를 출력한다.
 */

data class Node(val destination: Int, val weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.weight - other.weight  // 가중치 기준 오름차순 정렬
    }
}

fun dijkstra1753(graph: Array<ArrayList<Node>>, start: Int): IntArray {
    val n = graph.size
    val distances = IntArray(n) { Int.MAX_VALUE }
    distances[start] = 0

    val pq = PriorityQueue<Node>()
    pq.offer(Node(start, 0))

    while (pq.isNotEmpty()) {
        val current = pq.poll()
        val currentNode = current.destination
        val currentDistance = current.weight

        // 이미 처리된 노드는 스킵 (최적화)
        // 현재 꺼낸 거리가 이미 저장된 최단거리보다 크면 무시
        if (currentDistance > distances[currentNode]) continue

        // 현재 노드와 연결된 인접 노드들 확인
        for (edge in graph[currentNode]) {
            val nextNode = edge.destination
            val nextDistance = currentDistance + edge.weight

            // 더 짧은 경로를 발견한 경우 갱신
            if (nextDistance < distances[nextNode]) {
                distances[nextNode] = nextDistance
                pq.offer(Node(nextNode, nextDistance))
            }
        }
    }

    return distances
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (v, e) = readLine().split(" ").map { it.toInt() }
    val k = readLine().toInt()

    // 그래프 초기화 (정점 번호가 1부터 시작하므로 v+1 크기로 생성)
    val graph = Array(v + 1) { ArrayList<Node>() }

    // 간선 정보 입력
    repeat(e) {
        val (u, v, w) = readLine().split(" ").map { it.toInt() }
        graph[u].add(Node(v, w))
    }

    // 다익스트라 알고리즘 실행
    val distances = dijkstra1753(graph, k)

    // 결과 출력 (1번 정점부터 V번 정점까지)
    for (i in 1..v) {
        if (distances[i] == Int.MAX_VALUE) {
            println("INF")
        } else {
            println(distances[i])
        }
    }
}

/**
 * 알고리즘 동작 과정 설명:
 *
 * 1. 초기화
 *    - 모든 정점까지의 거리를 무한대(Int.MAX_VALUE)로 설정
 *    - 시작 정점의 거리만 0으로 설정
 *
 * 2. 우선순위 큐 활용
 *    - 항상 현재까지 발견된 최단 거리가 가장 짧은 노드를 먼저 처리
 *    - 이미 처리된 노드는 스킵 (currentDistance > distances[currentNode])
 *
 * 3. 인접 노드 탐색 및 갱신
 *    - 현재 노드를 거쳐서 가는 경로가 더 짧다면 거리 갱신
 *    - 갱신된 노드는 우선순위 큐에 추가
 *
 * 시간 복잡도: O((V+E) log V)
 * - 우선순위 큐에서 노드를 꺼내는 연산: O(log V)
 * - 최악의 경우 모든 간선에 대해 수행: O(E log V)
 *
 * 공간 복잡도: O(V + E)
 * - 그래프 저장: O(E)
 * - 거리 배열: O(V)
 * - 우선순위 큐: O(V)
 */