package zad2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    //zad 2
    //zwróci pozycję dwóch elementów,
    //których suma będzie równa wskazanej w argumentach liczby.

    public static int[] spot(List<Integer> a, int sum){
        if(a == null || a.size() == 0)
            throw new IllegalArgumentException("Array is empty");
        for(int i = 0; i < a.size()-1; i++){
            for(int j = i + 1; j < a.size(); j++){
                if(a.get(i) + a.get(j) == sum){
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("Nothing sum up to the sum");
    }

    public static void test()  {
        List<Integer> list = new ArrayList<>(Arrays.asList( 200,121, 4, 175, 172, 10));
        int sum = 14;
        int[] tab = spot(list, sum);
        if(tab.length == 0){
            //EXCEPTION
            throw new IllegalArgumentException("impossible");
        }
        System.out.println("Place in a list: "+ tab[0] +" and  "+ tab[1] + " sum up to: "+ sum);


    }
    public static void main(String[] args) throws Exception { test(); }

}
