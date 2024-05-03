package com.study.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
public class PccpTest {
    @Test
    public void test1Action(){

        String input_string1 = "edeaaabbccd";
        String input_string2 = "eeddee";
        String input_string3 = "string";

        String answer1 = "de";
        String answer2 = "e";
        String answer3 = "N";
        Assertions.assertEquals(answer1, test1(input_string1));
        Assertions.assertEquals(answer2, test1(input_string2));
        Assertions.assertEquals(answer3, test1(input_string3));
    }

    private String test1(String input_string) {
        input_string = "." + input_string + ".";
        String[] arr = {};
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            arr = input_string.split(String.valueOf(ch));
            list = Arrays.stream(arr).filter(str -> !"".equals(str)).collect(Collectors.toList());
            if (list.size() > 2) sb.append(ch);
        }
        return sb.length() == 0 ? "N" : sb.toString();
    }
}
