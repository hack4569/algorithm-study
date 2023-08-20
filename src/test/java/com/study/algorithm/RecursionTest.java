package com.study.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
}
