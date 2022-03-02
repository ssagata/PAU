package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import zad1.SelectionSort;
import zad1.ShellSort;
import zad1.Sort;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static zad1.Main.*;

class ShellSortTest {

    @Test
    void sortInShellSortTest_isEmpty_True() {
        int[] tab = {};
        Sort s = new Sort(new ShellSort());
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->s.sortStrategy(tab));
    }

    @Test
    void sortInShellSortTest_isWorking_True(){
        int[] expectedTab = {1,2,3,4,5};
        int [] tab = {5,4,3,1,2};
        Sort s  = new Sort(new ShellSort());
        s.sortStrategy(tab);
        Assertions.assertArrayEquals(expectedTab,tab);
    }

    @Test
    void optimisticTestInMain_True(){
        Sort s = new Sort(new ShellSort());
        Assertions.assertTimeout(Duration.ofMillis(1000), ()->s.sortStrategy(optimistic()));
    }
    @Test
    void pessimisticTestInMain_True(){
        Sort s = new Sort(new ShellSort());
        Assertions.assertTimeout(Duration.ofMillis(1000), ()->s.sortStrategy(pessimistic()));
    }
    @Test
    void randomTestInMain_True(){
        Sort s = new Sort(new ShellSort());
        Assertions.assertTimeout(Duration.ofMillis(1000), ()->s.sortStrategy(random()));
    }
}