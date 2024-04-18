package com.study.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class HashTest {
    @Test
    public void test1Action() {
        String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book1 = {"123","456","789"};
        Assertions.assertEquals(false, test1(phone_book));
        Assertions.assertEquals(true, test1(phone_book1));
    }

    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/42577?language=java
     * @param phone_book
     * @return
     */
    private boolean test1(String[] phone_book) {
        Set<String> set = new HashSet<>();
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length; i++) {
            if (i == 0) {
                set.add(phone_book[i]);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (char ch : phone_book[i].toCharArray()) {
                sb.append(ch);
                if (set.contains(sb.toString()) && !phone_book[i].equals(sb.toString())) return false;
            }
            set.add(phone_book[i]);
        }
        return true;
    }

    @Test
    public void test2Action() {
        String param = "people";
        String param1 = "We are the world";
        String answer = "peol";
        String answer1 = "We arthwold";

        Assertions.assertEquals(answer, test2(param));
        Assertions.assertEquals(answer1, test2(param1));
    }

    /**
     * 중복된 문자제거
     * https://school.programmers.co.kr/learn/courses/30/lessons/120888
     * @param my_string
     * @return
     */
    private String test2(String my_string) {
        char[] chs = my_string.toCharArray();
        Set set = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (char ch : chs) {
            if (set.contains(ch)) continue;
            set.add(ch);
            sb.append(ch);
        }

        return sb.toString();
    }

    @Test
    public void test3Action() {
        String before = "olleh";
        String after = "hello";
        int answer = 1;

        Assertions.assertEquals(1, test3_1(before, after));
        Assertions.assertEquals(1, test3_2(before, after));
    }

    /**
     * a로 b 만들기
     * https://school.programmers.co.kr/learn/courses/30/lessons/120886
     * @param before
     * @param after
     * @return
     */
    private int test3_1(String before, String after) {
        char[] chs1 = before.toCharArray();
        char[] chs2 = after.toCharArray();
        Arrays.sort(chs1);
        Arrays.sort(chs2);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (char ch : chs1) {
            sb1.append(ch);
        }
        for (char ch2 : chs2) {
            sb2.append(ch2);
        }
        if (sb1.toString().equals(sb2.toString())) {
            return 1;
        } else {
            return 0;
        }
    }

    private int test3_2(String before, String after) {
        return toMap(before).equals(toMap(after)) ? 1 : 0;
    }
    private Map<Character, Integer> toMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c)+1);
        }
        return map;
    }
}
