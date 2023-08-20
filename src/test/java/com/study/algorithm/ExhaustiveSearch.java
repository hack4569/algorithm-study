package com.study.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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
    @Test
    public void test2(){
        int brown = 10;
        int yellow = 2;
        int[] answer = {4, 3};
        Assertions.assertArrayEquals(answer, test2Action(brown, yellow));
    }
    public int[] test2Action(int brown, int yellow){
        for(int width=3; width<=5000; width++){
            for(int height=3; height<=width; height++){
                int boundary = (width + height -2) * 2;
                int center = width * height - boundary;

                if(brown == boundary && yellow == center){
                    return new int[] {width, height};
                }
            }
        }
        return null;
    }

    @Test
    public void test3Action(){
        String numbers = "17";
        assertEquals(test3(numbers), 3);
        numbers = "011";
        assertEquals(test3(numbers), 2);
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i=2; i*i <= n; i++){
            if (n%i==0) return false;
        }
        return true;
    }

    private Set<Integer> getPrimes(int acc, List<Integer> numbers){
        Set<Integer> primes = new HashSet<>();
        if (isPrime(acc)) primes.add(acc);

        for (int i=0; i<numbers.size(); i++){
            int nextAcc = acc * 10 + numbers.get(i);
            List<Integer> nextNumbers = new ArrayList<>(numbers);
            nextNumbers.remove(i);
            primes.addAll(getPrimes(nextAcc, nextNumbers));
        }
        return primes;
    }

    public int test3(String nums){
        List<Integer> numbers = nums.chars()
                .map(c -> c - '0')
                .boxed()
                .collect(Collectors.toList());
        return getPrimes(0, numbers).size();
    }
}
