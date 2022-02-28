package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import zad1.BubbleSort;
import zad1.HeapSort;
import zad1.Sort;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static zad1.Main.*;

class HeapSortTest {

    @Test
    void sort_HeapSort_isEmpty() {
        int[] tab = {};
        Sort s = new Sort(new HeapSort());
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->s.sortStrategy(tab));
    }

    @Test
    void sort_HeapSort_isWorking(){
        int[] expectedTab = {1,2,3,4,5};
        int [] tab = {5,4,3,1,2};
        Sort s  = new Sort(new HeapSort());
        s.sortStrategy(tab);
        Assertions.assertArrayEquals(expectedTab,tab);
    }

    @Test
    void optimisticTest_HeapSort(){
        Sort s = new Sort(new HeapSort());
        Assertions.assertTimeout(Duration.ofMillis(1000), ()->s.sortStrategy(optimistic()));
    }
    @Test
    void pessimisticTest_HeapSort(){
        Sort s = new Sort(new HeapSort());
        Assertions.assertTimeout(Duration.ofMillis(1000), ()->s.sortStrategy(pessimistic()));
    }
    @Test
    void randomTest_HeapSort(){
        Sort s = new Sort(new HeapSort());
        Assertions.assertTimeout(Duration.ofMillis(1000), ()->s.sortStrategy(random()));
    }

}