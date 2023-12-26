public class QuickSort implements SortAlgorithm 
{

    @Override
    public void sort(int[] arr, Visualizer visualizer) 
    {
        quickSort(arr, 0, arr.length - 1, visualizer);
    }

    private void quickSort(int[] arr, int low, int high, Visualizer visualizer) 
    {
        if (low < high) 
        {
            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1, visualizer);
            quickSort(arr, partitionIndex + 1, high, visualizer);

            // Notify the visualizer
            visualizer.updateArray(arr);
        }
    }

    private int partition(int[] arr, int low, int high) 
    {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) 
        {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) 
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
