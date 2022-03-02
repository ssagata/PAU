package zad4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void reorderDigits(int[] tab, String s){

        String here;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < tab.length; i++){
            //pobranie pierwszej liczby
            here = String.valueOf(tab[i]);

            //rozdzielenie na cyfry
            for(int j = 0; j < here.length(); j++) {
                list.add(Character.getNumericValue(here.charAt(j)));
            }

            if(s.equals("asc"))
                Collections.sort(list);
            else if(s.equals("desc")){
                Collections.sort(list);
                Collections.reverse(list);
            }

            tab[i] = 0;
            int tmp = list.size()-1;
            for(int k = 0; k < list.size(); k++){
                tab[i] += list.get(k)*Math.pow(10, tmp);
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
        int[] tab = {515, 341, 98, 44, 211};
        reorderDigits( tab, "asc");
        print(tab);
        reorderDigits(tab, "desc");
        print(tab);
        int[] tab2 = {63251, 78221};
        reorderDigits(tab2, "asc");
        print(tab2);
        reorderDigits(tab2, "desc");
        print(tab2);
    }
    public static void main(String[] args) { test(); }
}
