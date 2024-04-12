package com.study.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


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

    @Test
    public void test2Action() {
        String s = "Zbcdefg";
        s = s.chars().boxed().sorted((v1, v2) -> v2 - v1)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
        Assertions.assertEquals(s, "gfedcbZ");
    }

    @Test
    public void test3Action() {
        String[] sArr1 = {"sun", "bed", "car"};
        String[] sArr2 = {"abce", "abcd", "cdx"};

        String[] answer1 = {"car", "bed", "sun"};
        String[] answer2 = {"abcd", "abce", "cdx"};
        Assertions.assertArrayEquals(this.test3(sArr1,1), answer1);
        Assertions.assertArrayEquals(this.test3(sArr2,2), answer2);
    }

    private String[] test3(String[] strings, int n) {
        Arrays.sort(strings, (v1, v2) -> {
            String s1 = v1.substring(n, n+1);
            String s2 = v2.substring(n, n+1);
            if (s1.equals(s2)) {
                return v1.compareTo(v2);
            }
            return s1.compareTo(s2);
        });
        return strings;
    }
}
