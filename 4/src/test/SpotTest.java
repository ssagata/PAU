package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static zad2.Main.spot;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;


class SpotTest {

    @Test
    void spot_IsEmpty_True() {
        List<Integer> list = new ArrayList<>();
        int sum = 5;

      Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> spot(list, sum)
        );
    }

    @Test
    void spot_IsNull_True(){
        List<Integer> a = null;
        int sum = 5;

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> spot(a, sum));
    }

    @Test
    void spot_NothingSumUpToSum_True(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        int sum = 15;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> spot(list,sum));
    }

    @Test
    void spot_IsWorking_Result(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        int sum = 13;
        int [] result  = spot(list, sum);
        Assertions.assertArrayEquals(new int[]{5,6}, result);
    }

}