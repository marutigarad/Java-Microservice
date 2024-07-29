package org.example.pattern;

public class Dimond {

    public static  void  main(String [] args){

        String  abc;
        int n= 4;
        char ctr = 'A';

        for(int i=0; i<n; i++){
            System.out.println(" ");

            for(int j=4 ; j>i; j--){
                System.out.print(" ");
            }
            for(int k=0; k<i; k++){
                System.out.print(ctr +" ");
                ctr++;
            }
        }
        for(int i=0; i<n; i++){
            System.out.println(" ");

            for(int j=0 ; j<i; j++){
                System.out.print(" ");

            }
            for(int k=4; k>i; k--){
                System.out.print(ctr+" ");
                ctr++;
            }
        }


    }
}
