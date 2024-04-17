package com.study.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
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

    @Test
    public void test4Action() {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        int[] answer = Arrays.stream(query).mapToInt(v1 -> {
            String[] allQuery = v1.split("and");
            String lang = allQuery[0].trim();
            String job = allQuery[1].trim();
            String level = allQuery[2].trim();
            String[] lastStr = allQuery[3].split(" ");
            String food = lastStr[lastStr.length-2];
            int score = Integer.parseInt(lastStr[lastStr.length-1]);

            long sum = Arrays.stream(info).filter(infoI -> {
                String[] infos = infoI.split(" ");
                int infoScore = Integer.parseInt(infos[infos.length-1]);
                return infoScore >= score &&
                        this.findKeyWord(infoI, lang) &&
                        this.findKeyWord(infoI, job) &&
                        this.findKeyWord(infoI, level) &&
                        this.findKeyWord(infoI, food)
                        ;
            }).count();
            return (int) sum;
        }).toArray();

        int[] target = {1,1,1,1,2,4};
        Assertions.assertArrayEquals(answer, target);

    }

    private boolean findKeyWord(String infoI, String target) {
        return target.equals("-") ? true : infoI.indexOf(target) != -1;
    }

    @Test
    public void test5Action() {
        int[] nums1 = {3,3,2,4,5};
        int answer1 = 2;
        int[] nums2 = {3,3,3,2,2,2};
        int answer2 = 2;
        Assertions.assertEquals(answer1, test5(nums1));
        Assertions.assertEquals(answer2, test5(nums2));
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/1845
     * @param nums
     * @return
     */
    private int test5(int[] nums) {
        int length = (int) nums.length / 2;
        nums = Arrays.stream(nums).distinct().toArray();
        return length < nums.length ? length : nums.length;
    }


}
