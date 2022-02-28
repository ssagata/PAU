package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import zad1.BubbleSort;
import zad1.Main;
import zad1.Sort;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static zad1.Main.*;
import static zad3.Main.missingNum;

class BubbleSortTest {

    @Test
    void sort_BubbleSort_isEmpty() {
        int[] tab = {};
        Sort s = new Sort(new BubbleSort());
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->s.sortStrategy(tab));
    }

    @Test
    void sort_BubbleSort_isWorking(){
    int[] expectedTab = {1,2,3,4,5};
    int [] tab = {5,4,3,1,2};
    Sort s  = new Sort(new BubbleSort());
    s.sortStrategy(tab);
    Assertions.assertArrayEquals(expectedTab,tab);
    }

    @Test
    void optimisticTest(){
    Sort s = new Sort(new BubbleSort());
    Assertions.assertTimeout(Duration.ofMillis(1000), ()->s.sortStrategy(optimistic()));
    }
    @Test
    void pessimisticTest(){
        Sort s = new Sort(new BubbleSort());
        Assertions.assertTimeout(Duration.ofMillis(1000), ()->s.sortStrategy(pessimistic()));
    }
    @Test
    void randomTest(){
        Sort s = new Sort(new BubbleSort());
        Assertions.assertTimeout(Duration.ofMillis(1000), ()->s.sortStrategy(random()));
    }
}