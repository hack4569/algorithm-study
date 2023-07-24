package com.study.algorithm.String;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class StringTest {
    @Test
    public void 문자열_테스트1(){
        String s = "my name is leesanghak";
        String[] stringArr = s.split(" ");
        StringBuilder d = new StringBuilder();


        for(String s1 : stringArr){
            for(int i=0; i<s1.length(); i++){
                if(i%2==0){
                    d.append(Character.toUpperCase(s1.charAt(i)));
                }else {
                    d.append(s1.charAt(i));
                }
            }

            d.append(" ");
        }
        String result = d.toString().trim();
        String expected = "My NaMe Is LeEsAnGhAk";
        assertEquals(expected, result);
    }

    @Test
    public void 문자열_테스트1_정답(){
        StringBuilder builder = new StringBuilder();
        boolean toUpper = true;
        String s = "my name is leesanghak";
        for(char c : s.toCharArray()){
            if(!Character.isAlphabetic(c)){
                builder.append(c);
                toUpper = true;
            }else{
                if(toUpper){
                    builder.append(Character.toUpperCase(c));
                }else {
                    builder.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper;
            }
        }
        assertEquals("My NaMe Is LeEsAnGhAk",builder.toString());
    }
}