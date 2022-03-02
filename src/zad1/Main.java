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
        double time;
        int[] randomArr = random();
        int[] copyOfrandom = Arrays.copyOf(randomArr, randomArr.length);

        Sort tmp = new Sort(new BubbleSort());

        //BubbleSort
        System.out.println("Bubble sort");
        time = tmp.sortStrategy(optimistic());
        System.out.println("Optimistic: "  + time);
        time = tmp.sortStrategy(pessimistic());
        System.out.println("Pessimistic: " + time);
        time = tmp.sortStrategy(copyOfrandom);
        System.out.println("Random: " + time);

        tmp.changeStrategy(new HeapSort());
        copyOfrandom = Arrays.copyOf(randomArr, randomArr.length);

        //HeapSort
        System.out.println();
        System.out.println("Heap sort");
        time = tmp.sortStrategy(optimistic());
        System.out.println("Optimistic: "  + time );
        time = tmp.sortStrategy(pessimistic());
        System.out.println("Pessimistic: " + time);
        time = tmp.sortStrategy(copyOfrandom);
        System.out.println("Random: " + time);

        tmp.changeStrategy(new InsertionSort());
        copyOfrandom = Arrays.copyOf(randomArr, randomArr.length);

        //InsertionSort
        System.out.println();
        System.out.println("Insertion sort");
        time = tmp.sortStrategy(optimistic());
        System.out.println("Optimistic: "  + time );
        time = tmp.sortStrategy(pessimistic());
        System.out.println("Pessimistic: " + time);
        time = tmp.sortStrategy(copyOfrandom);
        System.out.println("Random: " + time);

        tmp.changeStrategy(new SelectionSort());
        copyOfrandom = Arrays.copyOf(randomArr, randomArr.length);

        //SelectionSort
        System.out.println();
        System.out.println("Selection sort");
        time = tmp.sortStrategy(optimistic());
        System.out.println("Optimistic: "  + time );
        time = tmp.sortStrategy(pessimistic());
        System.out.println("Pessimistic: " + time);
        time = tmp.sortStrategy(copyOfrandom);
        System.out.println("Random: " + time);

        tmp.changeStrategy(new ShellSort());
        copyOfrandom = Arrays.copyOf(randomArr, randomArr.length);

        //ShellSort
        System.out.println();
        System.out.println("Shell sort");
        time = tmp.sortStrategy(optimistic());
        System.out.println("Optimistic: "  + time );
        time = tmp.sortStrategy(pessimistic());
        System.out.println("Pessimistic: " + time);
        time = tmp.sortStrategy(copyOfrandom);
        System.out.println("Random: " + time);

    }
    public static void main(String[] args){test();}
}

