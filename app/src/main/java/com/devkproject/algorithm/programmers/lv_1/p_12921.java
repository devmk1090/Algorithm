package com.devkproject.algorithm.programmers.lv_1;

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/12921
 * 소수 찾기
 */

public class p_12921 {

    int p_12921(int n) {
        int answer = 0;
        boolean[] prime = new boolean[n + 1];

        for (int i = 2; i <= n; i++){
            prime[i] = true; //2 ~ n번째 수 초기화
        }

        int root = (int) Math.sqrt(n);
        for (int i = 2; i <= root; i++) {
            if (prime[i]) {
                for (int j = i; i * j <= n; j++) {
                    prime[i * j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                answer++;
            }
        }

        return answer;
    }

    int p_12921AS(int n) {
        int result = 0;
        for(int i = 2; i <= n; i++){
            for(int j = 2; j <= i; j++){
                if(j == i){
                    ++result;
                } else if(i % j == 0){
                    break;
                }
            }
        }

        return result;
    }
}
