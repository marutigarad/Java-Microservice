package org.example.pattern;

import java.util.Arrays;
import java.util.HashMap;

public class interviewQuestions {

    public  static  void main(String [] arges){
        int [] arr ={1,2,3,4,5,6,7,8,9}; //target = 11
       // find the count of the pairs whose sum is equals to target
        HashMap<Integer, Integer> maps = new HashMap<>();
        int count = 0;

        for(int num : arr){
            int sum =  11- num;
            if(maps.containsKey(sum)){
                count++;

            }
            maps.put(num, maps.getOrDefault(num, 0) +1);

        }
        System.out.println(count);

    }
}
