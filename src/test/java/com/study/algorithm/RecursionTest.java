package com.study.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RecursionTest {
    @Test
    public void test1Action(){
        Assertions.assertEquals(9, test1(3,2));
    }
    public int test1(int a, int b){
        if(a==0 || a==1 || b==0){
            return 1;
        }
        return a * test1(a, b - 1);
    }

    @Test
    public void test2Action() {
        String word = "AAAAE";
        int answer = 6;

        Assertions.assertEquals(answer, test2("").indexOf(word));
    }

    private static final char[] CHARS = "AEIOU".toCharArray();

    private List<String> test2(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);

        if (word.length() == 5) return words;

        for (char c : CHARS) {
            words.addAll(test2(word + c));
        }
        return words;
    }
}
