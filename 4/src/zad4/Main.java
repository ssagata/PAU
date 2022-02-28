package zad4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


//zad4
//uporządkuj dla każdej
//z nich cyfry w porządku rosnącym (asc) lub malejącym (desc)

public class Main {

        public static void reorderDigits(int[] arr, String s){

            if(arr.length == 0){
                throw new IllegalArgumentException("Array is empty");
            }
            if(!s.equals("asc") && !s.equals("desc")){
                throw new IllegalArgumentException("You can choose only asc or desc!");
            }
            String current;
            List<Integer>list = new ArrayList<>();

                for ( int i = 0; i < arr.length; i++){
                //pobranie pierwszej liczby
                current = String.valueOf(arr[i]);

                //rozdzielenie na cyfry
                for(int j = 0; j < current.length(); j++) {
                    list.add(Character.getNumericValue(current.charAt(j)));
                }

                if(s.equals("asc"))
                    Collections.sort(list);
                else if(s.equals("desc")){
                    Collections.sort(list);
                    Collections.reverse(list);
                }

                arr[i] = 0;
                int tmp = list.size()-1;
                for(int k = 0; k < list.size(); k++){
                    arr[i] += list.get(k)*Math.pow(10, tmp);
                    tmp--;
                }
                list.clear();
            }



        }
        public static void print(int[] tab){
            for(int i = 0; i < tab.length; i++) {
                if (i == tab.length - 1)
                    System.out.print(tab[i] + " ");
                else
                    System.out.print(tab[i] + " ");
            }
            System.out.println();

        }
        public static void test(){
            int[] arr = {515, 341, 98, 44, 211};
            reorderDigits( arr, "asc");
            print(arr);
            reorderDigits(arr, "desc");
            print(arr);
            int[] arr2 = {63251, 78221};
            reorderDigits(arr2, "asc");
            print(arr2);
            reorderDigits(arr2, "desc");
            print(arr2);
        }
        public static void main(String[] args) { test(); }
    }


