package com.study.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
}
