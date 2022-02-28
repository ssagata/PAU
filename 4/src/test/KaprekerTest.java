package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import zad5.Main;

import static org.junit.jupiter.api.Assertions.*;
import static zad4.Main.reorderDigits;
import static zad5.Main.allSameDigits;
import static zad5.Main.kaprekar;

class KaprekerTest {


    // allSameDigits
    @Test
    void allSameDigitsTest() {
        int num = 1111;
        boolean result  = allSameDigits(num);
        Assertions.assertTrue(result);
    }
    @Test
    void allSameDigits_minusNum_ThrowException(){
        int num = 0;
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->allSameDigits(num));
    }

    //reorderDigits
    @Test
    void reorderDigits_incorrectString_ThrowException(){
        int num  = 2;
        String s  = "abc";
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Main.reorderDigits(num,s)
        );
    }
    @Test
    void reorderDigits_escWorking(){
        int expectedNum = 1234;
        int num  = 3241;
        String s = "asc";
        int result = Main.reorderDigits(num,s);
        Assertions.assertEquals(expectedNum,result);
    }

    @Test
    void reorderDigits_descWorking(){
        int expectedNum = 4321;
        int num = 3241;
        String s = "desc";
        int result = Main.reorderDigits(num,s);
        Assertions.assertEquals(expectedNum,result);
    }

    //kaprekr

    @Test
    void kaprekar_sameDigits_ThrowException(){
        int num = 1111;
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->Main.kaprekar(num));
    }
    @Test
    void kaprekar_NumTooBig_ThrowException(){
        int num =  12345;
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->Main.kaprekar(num));
    }

    @Test
    void kaprekar_KaprekarNumber_result(){
        int num = 6174;
        int expectedNum  = 0;
        int result = Main.kaprekar(num);
        Assertions.assertEquals(result, expectedNum);
    }


    @Test
    void kaprekar_IsWorking_result() {
        int num = 495;
        int expectedNum = 4;
        int result = Main.kaprekar(num);
        Assertions.assertEquals(expectedNum,result);
    }

    @Test
    void kaprekar_minusKaprekar_ThrowException(){
        int num = -3;
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->Main.kaprekar(num));
    }
}