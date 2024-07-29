package org.example.pattern;

public class recursion {

    public static int factorial(int n){

        if(n<=1){
            return 1;
        }
        else {
           return n * factorial( n -1);
        }
    }

    public  static void main(String []agrs){

        int n = 5;
        int result = factorial(n);
        System.out.println("Factorial of " + n + " is " + result);

        String str= "monnom";

        int i=0, j=0, k =0;
        j= str.length()-1;
        while ( i <=str.length()-1){
            System.out.print(str.charAt(i));
            System.out.print("   "+str.charAt(j));
            --j;
            i++;
            System.out.println(" ");

        }


    }
}
