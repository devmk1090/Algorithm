package com.devkproject.algorithm.programmers.lv_1;

/**
 * Programmers Lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/17682
 * 다트 게임
 */

public class p_17682 {

    public int p_17682(String dartResult) {
        int answer = 0;

        String[] dart = dartResult.split("");
        int[] score = new int[3];

        int index = -1;
        for (int i = 0; i < dart.length; i++) {
            if (dart[i].matches("[0-9]")) { //숫자인지 정규식으로 확인
                index++;
                score[index] = Integer.parseInt(dart[i]);
                if (dart[i + 1].matches("[0-9]")) { //10점인지 확인
                    score[index] *= 10;
                    i++;
                }
            }

            //pow : 제곱
            switch (dart[i]) {
                case "D":
                    score[index] = (int)Math.pow(score[index], 2);
                    break;
                case "T" :
                    score[index] = (int)Math.pow(score[index], 3);
                    break;
                case "*" :
                    score[index] *= 2;
                    if(index - 1 >= 0) score[index - 1] *= 2;
                    break;
                case "#" :
                    score[index] *= -1;
            }
        }

        for (int s : score) {
            answer += s;
        }

        return answer;
    }
}
