package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import zad1.HeapSort;
import zad1.InsertionSort;
import zad1.Sort;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static zad1.Main.*;

class InsertionSortTest {


    @Test
    void sort_InseertionSort_isArrayEmpty_ThrowException() {
        int[] tab = {};
        Sort s = new Sort(new InsertionSort());
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->s.sortStrategy(tab));
    }

    @Test
    void sort_InsertionSort_isWorking(){
        int[] expectedTab = {1,2,3,4,5};
        int [] tab = {5,4,3,1,2};
        Sort s  = new Sort(new InsertionSort());
        s.sortStrategy(tab);
        Assertions.assertArrayEquals(expectedTab,tab);
    }

    @Test
    void optimisticTest(){
        Sort s = new Sort(new InsertionSort());
        Assertions.assertTimeout(Duration.ofMillis(1000), ()->s.sortStrategy(optimistic()));
    }
    @Test
    void pessimisticTest(){
        Sort s = new Sort(new InsertionSort());
        Assertions.assertTimeout(Duration.ofMillis(1000), ()->s.sortStrategy(pessimistic()));
    }
    @Test
    void randomTest(){
        Sort s = new Sort(new InsertionSort());
        Assertions.assertTimeout(Duration.ofMillis(1000), ()->s.sortStrategy(random()));
    }

}