package com.study.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;


@SpringBootTest
public class ArrayTest {
    @Test
    public void test1Action(){
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] real = {5,6,3};
        Assertions.assertArrayEquals(real, test1(array, commands));
    }

    public int[] test1(int[] array, int[][] commands){
        int[] answer = new int[commands.length];
        for (int i = 0; i < answer.length; i++){
            int[] command = commands[i];
            int from = command[0] - 1;
            int to = command[1];
            int k = command[2] - 1;
            int[] sub = Arrays.copyOfRange(array, from , to);
            Arrays.sort(sub);
            answer[i] = sub[k];
        }
        return answer;
    }
}
