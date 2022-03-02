package zad5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static int reorderDigits(int a, String s){

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
        int counter = 0;
        int asc;
        int desc;
        while(a != 6174){
           if(a == 1111 ){throw new IllegalArgumentException("There have to be two different numbers");}
           if (a == 2222){throw new IllegalArgumentException("There have to be two different numbers");}
           if(a == 3333){throw new IllegalArgumentException("There have to be two different numbers");}
           if(a == 4444){throw new IllegalArgumentException("There have to be two different numbers");}
           if(a == 5555){throw new IllegalArgumentException("There have to be two different numbers");}
           else{
               while(a < 1000)
                   a *= 10;
               asc = reorderDigits(a, "asc");
               desc = reorderDigits(a, "desc");
               System.out.println("od "+a+" do "+desc+" - "+asc);
               a = desc - asc;
               counter++;
           }
           }

        System.out.println("steps: "+ counter);
        return counter;

    }
    public static void main(String[] args) {
        System.out.println(kaprekar(1111));
    }

}
