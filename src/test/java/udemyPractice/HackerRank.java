package udemyPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class HackerRank {

    @Test
    public void test() {
       String s1="sada";
       String s2="anu";
       String s3="harish";
       StringBuilder sb=new StringBuilder();
       List<String> al= new ArrayList<String>();
       al.add(s1);
       al.add(s2);
       al.add(s3);
       Collections.sort(al);
       System.out.println(al);
       
       for(String s: al) {
           sb.append(s);
       }
       System.out.println("The concatenated string is "+sb);
    }
    }


