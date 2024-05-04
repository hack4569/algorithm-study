package com.study.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class QueueTest {
    @Test
    public void test1Action() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] workDay = new int[progresses.length];
        for ( int i =0; i < progresses.length; i++) {
            int val =(int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            workDay[i] = val;
        }
        List<Integer> list = new ArrayList<>();
        int k = 0;
        int count = 1;
        for (int j = 0; j < workDay.length; j++) {
             if (workDay[j] > k ){
                 if (j != 0) {
                     list.add(count);
                     count = 1;
                 }
                 k = workDay[j];
             } else {
                 count ++;
             }

            if (j == workDay.length -1) {
                list.add(count);
            }
        }
        int[] answer1 = {2, 1};
        int[] myAnswer1 = list.stream().mapToInt(Integer::intValue).toArray();
        Assertions.assertEquals(true, Arrays.equals(answer1, myAnswer1));
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/42586
     * @param progress
     * @param speeds
     * @return
     */
    @Test
    public int[] test1_solution(int[] progress, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progress.length; i++) {
            q.add(i);
        }
        List<Integer> result = new ArrayList<>();
        int days = 0;
        int count = 0;
        while (!q.isEmpty()) {
            int index = q.poll();
            int expiration = (int) Math.ceil( (double) (100 - progress[index]) / speeds[index]);
            if (expiration > days) {
                if (days != 0) {
                    result.add(count);
                    count = 0;
                }
                days = expiration;
            }
            count ++;
        }
        result.add(count);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
