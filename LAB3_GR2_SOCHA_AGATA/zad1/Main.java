package zad1;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static int[] optimistic(){
        int n = 10000;
        int[] arr = new int[n];
        for(int i = 0 ; i<n; i++){
            arr[i] = i;
        }
        return arr;
    }

    public static int[] pessimistic(){
        int n = 10000;
        int[] arr = new int[n];
        for(int i = n-1; i >=0; i--){
            arr[i] = i;
        }
        return arr;
    }

    public static int[] random(){
        int n = 10000;
        int[] arr = new int[n];
        Random random = new Random();
        for(int i = 0; i< n; i++){
            arr[i] = random.nextInt(n);
        }
        return arr;
    }


    public static void test(){
        double timeOpt,timePes, timeRandom;
        int[] randomArr = random();
        int[] copyOfrandom = Arrays.copyOf(randomArr, randomArr.length);

        Context tmp = new Context(new BubbleSort());
        timeOpt = tmp.sortStrategy(optimistic());
        timePes = tmp.sortStrategy(pessimistic());
        timeRandom = tmp.sortStrategy(copyOfrandom);

        //BubbleSort
        System.out.println("Bubble sort");
        System.out.println("Optimistic: " + timeOpt);
        System.out.println("Pessimistic: " + timePes);
        System.out.println("Random: " + timeRandom);

        tmp.changeStrategy(new HeapSort());
        copyOfrandom = Arrays.copyOf(randomArr, randomArr.length);

        //HeapSort
        System.out.println("Heap sort");
        System.out.println("Optimistic: " + timeOpt);
        System.out.println("Pessimistic: " + timePes);
        System.out.println("Random: " + timeRandom);

        tmp.changeStrategy(new InsertionSort());

        //InsertionSort
        System.out.println("Insertion sort");
        System.out.println("Optimistic: " + timeOpt);
        System.out.println("Pessimistic: " + timePes);
        System.out.println("Random: " + timeRandom);

        tmp.changeStrategy(new SelectionSort());

        //SelectionSort
        System.out.println("Selection sort");
        System.out.println("Optimistic: " + timeOpt);
        System.out.println("Pessimistic: " + timePes);
        System.out.println("Random: " + timeRandom);

        tmp.changeStrategy(new ShellSort());

        //ShellSort
        System.out.println("Shell sort");
        System.out.println("Optimistic: " + timeOpt);
        System.out.println("Pessimistic: " + timePes);
        System.out.println("Random: " + timeRandom);
        }
        public static void main(String[] args){test();}
    }

