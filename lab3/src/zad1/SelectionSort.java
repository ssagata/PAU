package zad1;

public class SelectionSort implements Strategy {

    @Override
    public double sort(int [] arr){

        long startTime = System.nanoTime();

        int n  = arr.length;

            for (int i = 0; i < n-1; i++)
            {
                int min_idx = i;
                for (int j = i+1; j < n; j++)
                    if (arr[j] < arr[min_idx])
                        min_idx = j;

                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }
        long estimatedTime = System.nanoTime() - startTime;
        return estimatedTime;
    }
}
