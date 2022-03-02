package zad3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static int[] missingNum(List<Integer> a, int max){
        Collections.sort(a);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < max; i++){
            if(i >= a.size()){
                list.add(i+1);
            }
            else if(a.get(i) != i + 1){
                a.add(i, i + 1);
                list.add(i + 1);
            }
        }
        int[] tab = new int[list.size()];
        for(int i = 0; i < tab.length; i++){
            tab[i] = list.get(i);
        }
        return tab;
    }


    public static void test(){
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 3, 7, 21, 5,9,11,13,15,17,19,23,24));
        int max = 24;
        int[] tab = missingNum(list,max);
        for(int i = 0; i < tab.length; i++)
            System.out.print(tab[i]+" ");
    }
    public static void main(String[] args) {
        test();
    }

}

