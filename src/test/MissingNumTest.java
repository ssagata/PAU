package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static zad2.Main.spot;
import static zad3.Main.missingNum;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumTest {

    @Test
    void missingNum_wrongMax_ThrowException() {
        List<Integer> list = Arrays.asList(2,3);
        int max = 0;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> missingNum(list,max));
    }

    @Test
    void missingNum_isArrayEmpty_ThrowExcption(){
        List<Integer> list = new ArrayList<>();
        int max = 5;
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> missingNum(list, max)
        );
    }

    @Test
    void missingNum_isArrayNull_Throwxception(){
        List<Integer> list = null;
        int max = 5;
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> missingNum(list,max)
        );
    }

    @Test
    void missingNum_isWorking (){
        List<Integer> list = new ArrayList<>(Arrays.asList(2,3,8,6));
        int max = 7;
        int [] result  = missingNum(list,max);
        Assertions.assertArrayEquals(new int[]{1,4,5,7},result);
    }






}