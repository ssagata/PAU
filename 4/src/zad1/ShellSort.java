package zad1;

public class ShellSort implements Strategy{
    @Override
    public double sort(int[] arr) {
        if(arr.length == 0)
            throw new IllegalArgumentException("Array is empty");
        long startTime = System.nanoTime();
        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
        long estimatedTime = System.nanoTime() - startTime;
        return estimatedTime;
    }

}
