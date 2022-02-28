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
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2));
        int max = 2;
        int[] tab = missingNum(list,max);
        for(int i = 0; i < tab.length; i++)
            if()
            System.out.print(tab[i]+" ");
    }
    public static void main(String[] args) {
        test();
    }

}

