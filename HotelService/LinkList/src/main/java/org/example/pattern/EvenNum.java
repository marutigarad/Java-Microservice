package org.example.pattern;

import java.util.List;
import java.util.stream.Collectors;

public class EvenNum {


    public static  void  main(String [] args){

        List<Integer> listnum= List.of(1,2,3,4,5,6,7,8,9,12);
        List<Integer> evenNumbers=listnum.stream().filter((i -> i%2==0)).collect(Collectors.toList());
        System.out.println(evenNumbers);


    }
}
