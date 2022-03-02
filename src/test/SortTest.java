package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import zad1.HeapSort;
import zad1.ShellSort;
import zad1.Sort;
import zad1.Strategy;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @Test
    void changeStrategy_IsWorking_True() {
        Sort s = new Sort(new ShellSort());

         s.changeStrategy(new HeapSort());
        Assertions.assertTrue(s.getStrategy() instanceof HeapSort);
    }

}