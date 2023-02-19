package com.devkproject.algorithm.dfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * DFS, Depth First Search(깊이 우선 탐색)
 * https://www.acmicpc.net/problem/1260 (DFS 와 BFS)
 * Tip:  DFS는 한 뱡향으로 계속가지만,
 * BFS는 갈 수 있는 곳을 미리 다 탐색해서 que에 집어 넣고, 모두 탐색한다.
 */

private var arr = Array(0) { Array(0) { 0 } }
private var visit = Array(0) { false }
private var sb = StringBuilder()

private var N : Int = 0;
private var M : Int = 0;
private var count : Int = 0;

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    N = st.nextToken().toInt(); // 정점의 개수
    M = st.nextToken().toInt(); // 간선의 개수
    var V = st.nextToken().toInt(); // 노드의 개수
    arr = Array(N+1) { Array(N + 1) { 0 } }
    visit = Array(N+1) { false };

    for(i in 1..M step 1) {
        st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt();
        val y = st.nextToken().toInt();

        arr[x][y] = 1;
        arr[y][x] = 1;
    }

    dfs(V)

    print(sb)
}

private fun dfs(nodeNum: Int) {
    visit[nodeNum] = true
    sb.append("${nodeNum} ");

    if (count == N) {
        return
    }
    count ++

    for (i in 1..N step 1) {
        if(arr[nodeNum][i] == 1 && !visit[i] ) {
            dfs(i);
        }
    }
}