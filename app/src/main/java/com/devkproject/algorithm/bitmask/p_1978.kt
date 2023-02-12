package com.devkproject.algorithm.bitmask

import java.util.*
import kotlin.math.sqrt

/**
 * BitMask(비트마스크)
 * https://www.acmicpc.net/problem/1978 (소수 찾기)
 *
 * shr : shift right
 * shl : shift left
 */

var MAX = 1000
var sieve: Array<Int>? = null

fun main() {
    eratos()

    val br = System.`in`.bufferedReader()
    val n = readLine()!!.toInt()
    var cnt = 0

    val st = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        val j = st.nextToken().toInt()
        if (isPrime(j))
            cnt++
    }
    println(cnt)
}

private fun eratos() {
    sieve = arrayOf((MAX / 8) + 1)
    Arrays.fill(sieve, 255)

    setComposite(0)
    setComposite(1)

    val sqrt_max = sqrt(MAX.toDouble()).toInt()

    for (i in 2..sqrt_max) {
        if (isPrime(i)) {
            var j = i * i
            while (j <= MAX) {
                setComposite(j)
                j += i
            }
        }
    }
}

private fun isPrime(n: Int): Boolean {
    return sieve!![n shr 3] and (1 shl (n and 7)) != 0
}

private fun setComposite(n: Int) {
    sieve!![n shr 3] = sieve!![n shr 3] and (1 shl (n and 7))
}