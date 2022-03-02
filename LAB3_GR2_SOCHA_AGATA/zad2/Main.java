package zad2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static int[] spot(List<Integer> a, int target){

           for(int i = 0; i < a.size()-1; i++){
               for(int j = i + 1; j < a.size(); j++){
                   if(a.get(i) + a.get(j) == target){
                       return new int[] {i, j};
                   }
               }
           }
           return new int[]{};
       }

    public static void test(){
        List<Integer> list = new ArrayList<>(Arrays.asList(121, 200, 4, 279, 179, 10));
        int target = 300;
        int[] tab = spot(list, target);
        if(tab.length == 0){
            //EXCEPTION
            throw new IllegalArgumentException("impossible");
        }
        System.out.println("Place in a list: "+ tab[0] +" and  "+ tab[1] + " sum up to: "+ target);


    }
    public static void main(String[] args) { test(); }

}
