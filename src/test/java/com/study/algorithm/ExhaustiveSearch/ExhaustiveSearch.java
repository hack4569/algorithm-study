package com.study.algorithm.ExhaustiveSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.IntStream;

@SpringBootTest
public class ExhaustiveSearch {

    @Test
    public void test1(){
        int[] answer = {1,2,3,4,5};
        int[] answerCount = {1};
        Assertions.assertArrayEquals(answerCount, test1Action(answer));
    }
    public int[] test1Action(int[] answer){
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        int[] answerCount = {0,0,0};
        int max = 0;
        for(int i=0; i<answer.length; i++){
            if(a[i%a.length] == answer[i]){
                if(++answerCount[0] > max){
                    max = answerCount[0];
                }
            }
            if(b[i%b.length] == answer[i]){
                if(++answerCount[1] > max){
                    max = answerCount[1];
                }
            }
            if(c[i%c.length] == answer[i]){
                if(++answerCount[2] > max){
                    max = answerCount[2];
                }
            }
        }

        final int maxCorrects = max;
        return IntStream.range(0,3)
                .filter(i -> answerCount[i] == maxCorrects)
                .map(i -> i+1)
                .toArray();
    }
}
