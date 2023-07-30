package com.study.algorithm.String;

import org.apache.logging.log4j.util.StringBuilders;
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
    public void 문자열_테스트1_1(){
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

//    @Test
//    public void 문자열_테스트2_압축(){
//        String data = "abcabbcc";
//        for(int i=1; i<data.length(); i++){
//            StringBuilder sb = new StringBuilder();
//            String prev = "";
//            int cnt = 1;
//            for(int j=1; j*i<data.length(); j++){
//                String thisData = data.substring(j-1,j);
//                if(prev.equals(thisData)){
//                    cnt++;
//                }else {
//                    if(cnt>0){
//                        sb.append(cnt);
//                        sb.append(prev);
//                        cnt = 1;
//                    }
//                }
//                prev = thisData;
//            }
//
//        }
//    }
    @Test
    public void 삼진법_뒤집기(){
        int n = 567;
        String str = Integer.toString(n,3);
        String reversed = new StringBuilder(str).reverse().toString();
        int answer = Integer.valueOf(reversed,3);
        System.out.println(answer);
        assertEquals(5,answer);
    }

    @Test
    public void 이진변환_반복하기(){
        String s = "110010101001";
        int loop = 0;
        int removed = 0;

        while(!s.equals("1")){
            int zeros = countZero(s);
            loop+=1;
            removed += zeros;

            int ones = s.length() - zeros;
            s = Integer.toString(ones, 2);
        }
        assertEquals(3, loop);
        assertEquals(8, removed);
    }
    private int countZero(String s){

        int zeros = 0;
        for(char c : s.toCharArray()){
            if(c == '0') zeros++;
        }
        return zeros;
    }
}