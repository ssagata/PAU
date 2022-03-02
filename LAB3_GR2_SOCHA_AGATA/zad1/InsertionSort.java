package zad1;

public class InsertionSort implements Strategy {
    @Override
    public double sort(int [] arr){

        long startTime = System.nanoTime();

        int n  = arr.length;

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        long estimatedTime = System.nanoTime() - startTime;
        return estimatedTime;
    }
}
