package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import zad1.HeapSort;
import zad1.SelectionSort;
import zad1.Sort;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static zad1.Main.*;

class SelectionSortTest {


    @Test
    void sortInSelectionSort_isEmpty_True() {
        int[] tab = {};
        Sort s = new Sort(new SelectionSort());
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->s.sortStrategy(tab));
    }

    @Test
    void sortInSelectionSort_isWorking_True(){
        int[] expectedTab = {1,2,3,4,5};
        int [] tab = {5,4,3,1,2};
        Sort s  = new Sort(new SelectionSort());
        s.sortStrategy(tab);
        Assertions.assertArrayEquals(expectedTab,tab);
    }

    @Test
    void ptimisticTestInMain_True(){
        Sort s = new Sort(new SelectionSort());
        Assertions.assertTimeout(Duration.ofMillis(1000), ()->s.sortStrategy(optimistic()));
    }
    @Test
    void pessimisticTestinMain_True(){
        Sort s = new Sort(new SelectionSort());
        Assertions.assertTimeout(Duration.ofMillis(1000), ()->s.sortStrategy(pessimistic()));
    }
    @Test
    void randomTestInMain_True(){
        Sort s = new Sort(new SelectionSort());
        Assertions.assertTimeout(Duration.ofMillis(1000), ()->s.sortStrategy(random()));
    }

}