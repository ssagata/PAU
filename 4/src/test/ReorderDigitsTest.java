package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static zad4.Main.reorderDigits;

class ReorderDigitsTest {

    @Test
        void reorderDigits_isArrayEmpty_True() {
        int [] tab = new int[]{};
        String s = "asc";
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> reorderDigits(tab, s)
        );
    }

    @Test
    void reorderDigits_incorrectString_True(){
        int [] tab = new int []{1,2,3};
        String s  = "abc";
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> reorderDigits(tab,s)
        );
    }

    @Test
    void reorderDigits_isFirstValueOK_True(){
       int [] tab = new int []{123,312,213};
       String expectedString = "123";
        String current  = String.valueOf(tab[0]);
       // reorderDigits(tab,current);
        Assertions.assertEquals(expectedString,current);
    }

    @Test
    void reorderDigits_IsEscWorking_True(){
        int [] expectedTab = {123,456,789};
        int[] tab = new int[] {312,526,987};
        String s = "asc";
        reorderDigits(tab,s);
        Assertions.assertArrayEquals(expectedTab, tab);
    }

    @Test
    void reorderDigits_IsDescWorking_True(){
        int [] expectedTab = {321,654,987};
        int [] tab = new int[]{312,256,789};
        String s = "desc";
        reorderDigits(tab,s);
        Assertions.assertArrayEquals(expectedTab, tab);
    }

}