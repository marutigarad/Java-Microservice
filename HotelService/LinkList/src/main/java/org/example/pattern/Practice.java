package org.example.pattern;


import java.util.HashMap;
import java.util.HashSet;

public class Practice {

    public int lengthOfLongestSubstring(String s) {
        int[] charIndex = new int[128];
        int maxLength = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            left = Math.max(charIndex[c], left);
            maxLength = Math.max(maxLength, right - left + 1);
            charIndex[c] = right + 1;
        }
        return maxLength;
    }

    public  void  hashSetPractice(){
        HashSet<String> set = new HashSet<>();
        // Add elements to the HashSet
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Date");
        set.add("");
        set.add(null);
        System.out.println(set);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("",1);
        map.put("",1);
        map.put("Banana",1);
        map.put("Date",1);
        map.put(null, null);
        map.put("Apple", null);

        System.out.println(map);

    }
    public static void main(String [] args){
        Practice pr= new Practice();
        pr.hashSetPractice();
        System.out.println(pr.lengthOfLongestSubstring("abc abcdefghijklmnopqrstuvwxyz"));



        //Find smallest odd number
        int [] arr = {100,122,367,378,478,901,839,849,452,129,290,138,299,827,388,232,104,928,302,348,340,124,435,346,235,117,103,102,875,908};
        String  [] str = {"abc","svy","bee"};
        int smallOddNum = 0;
        int temp= 8789;
        HashSet<Integer> number= new HashSet<>();
        for(int i=1; i<arr.length; i++){
            if(arr[i]%2!=0){
                number.add(arr[i]);
            }

            if(temp>arr[i]) {
                temp = arr[i];
                if (temp % 2 != 0) {
                    smallOddNum = temp;
                }

            }
        }
        System.out.println("this is set "+number);
        System.out.println("small number is "+smallOddNum);
    }
}
