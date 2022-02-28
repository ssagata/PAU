package zad1;

public class BubbleSort implements Strategy {

    @Override
    public double sort(int[] arr) {

        if(arr.length == 0)
            throw new IllegalArgumentException("Array is empty");
        long startTime = System.nanoTime();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        long estimatedTime = System.nanoTime() - startTime;
        return estimatedTime;

    }

}
