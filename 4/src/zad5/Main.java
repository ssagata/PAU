package zad5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    public static boolean allSameDigits(int num){

        if(num <= 0){
            throw new IllegalArgumentException("The number has to be positive");
        }
        String current1;
        current1 = String.valueOf(num);
        List<Integer> lista1 = new ArrayList<>();
        for(int i = 0; i < current1.length();i++){
            lista1.add(Character.getNumericValue(current1.charAt(i)));
        }
        for(int j = 0; j < current1.length()-1; j++){
            if(lista1.get(j) != lista1.get(j+1)){
                return false;
            }
        }
        return true;
    }
        public static int reorderDigits(int a, String s){

            if(!s.equals("asc") && !s.equals("desc")){
                throw new IllegalArgumentException("You can choose only asc or desc!");
            }
            String current;
            List<Integer> list = new ArrayList<>();
            current = String.valueOf(a);
            for(int j = 0; j < current.length(); j++) {
                list.add(Character.getNumericValue(current.charAt(j)));
            }
            if(s.equals("asc"))
                Collections.sort(list);
            else if(s.equals("desc")){
                Collections.sort(list);
                Collections.reverse(list);
            }
            a = 0;
            int tmp = list.size()-1;
            for(int k = 0; k < list.size(); k++){
                a += list.get(k)*Math.pow(10, tmp);
                tmp--;
            }
            list.clear();
            return a;
        }

        public static int kaprekar(int a){
            if(allSameDigits(a) == true) {
                throw new IllegalArgumentException("There have to be two different numbers!");
            } else if(a > 9999){
                throw new IllegalArgumentException("The number has to be smaller than 10000");
            }
            int counter=0;
            int asc;
            int desc;
            while(a != 6174){
                while(a < 1000)
                    a *= 10;
                asc = reorderDigits(a, "asc");
                desc = reorderDigits(a, "desc");
                System.out.println("od "+a+" do "+desc+" - "+asc);
                a = desc - asc;
                counter++;
            }
            return counter;
        }
        public static void main(String[] a) {
            System.out.println(kaprekar(1111));
        }

    }


