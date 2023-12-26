public class MergeSort implements SortAlgorithm 
{

    @Override
    public void sort(int[] arr, Visualizer visualizer) 
    {
        mergeSort(arr, 0, arr.length - 1, visualizer);
    }

    private void mergeSort(int[] arr, int left, int right, Visualizer visualizer) 
    {
        if (left < right) 
        {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid, visualizer);
            mergeSort(arr, mid + 1, right, visualizer);

            merge(arr, left, mid, right);

            // Notify the visualizer
            visualizer.updateArray(arr);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) 
    {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) 
        {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) 
        {
            temp[k++] = arr[i++];
        }

        while (j <= right) 
        {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}
